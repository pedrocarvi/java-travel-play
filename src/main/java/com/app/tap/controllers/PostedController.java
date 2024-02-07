package com.app.tap.controllers;


import com.app.tap.entitites.Posted;
import com.app.tap.entitites.Uuser;
import com.app.tap.entitites.dtos.Posted_Create_Dto;
import com.app.tap.entitites.dtos.Posted_Edit_Dto;
import com.app.tap.entitites.dtos.Posted_Get_Dto;
import com.app.tap.exceptions.BadRequestException;
import com.app.tap.exceptions.ResourceNotFoundException;
import com.app.tap.service.Mapping.PostedMapping;
import com.app.tap.service.PostedService;
import com.app.tap.service.UuserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posted")
public class PostedController {

        @Autowired
        PostedService _postedService;
        UuserService _uuserService;


        private PostedMapping _postedMapping;
        @Autowired
        public void SetPostedMapping(PostedMapping postedMapping){
        _postedMapping = postedMapping;
    }
        public void SetUuserService(UuserService uuserService){_uuserService =uuserService;}




    @PostMapping("/create")
        public ResponseEntity<Posted> newPosted(@RequestBody Posted_Create_Dto posted_dto) throws BadRequestException {

               Posted new_posted =  _postedMapping.convertDTOToPosted(posted_dto);           //Mapeo el dto a posteo y lo guardo en variable.
                _postedService.newPosted(new_posted);                                          //Guardo el posteo con los servicios.

                return ResponseEntity.ok(new_posted);   //Retorno ok en la response.

        }

        @GetMapping("/getAll")
        public ResponseEntity<List> getAllPosted() throws ResourceNotFoundException {

                        List<Posted> postedList = _postedService.getAll();       //Guardo la lista de posteos en una varieble.


                        return  ResponseEntity.ok(postedList); //Retorno la lista de posteos
        }

        @GetMapping("/getById/{id}")
        public ResponseEntity<Posted_Get_Dto> getById(@PathVariable Integer id) throws  ResourceNotFoundException {

                Posted get_posted = _postedService.findByIdPosted(id).orElse(null);
                if (get_posted == null){
                    throw new ResourceNotFoundException("The post with id " + id + " has not been found");
                }

                Posted_Get_Dto get_posted_dto = _postedMapping.convertPostedToDTO(get_posted);

                return  ResponseEntity.ok(get_posted_dto);
        }


        @DeleteMapping("deletById/{id}")
        public ResponseEntity<String> deletPostedById(@PathVariable Integer id) throws ResourceNotFoundException{

            _postedService.deletPosted(id);

           // Posted get_posted = _postedService.findByIdPosted(id).orElse(null);
                    //if (get_posted == null){
                        return ResponseEntity.ok("Post with id "+ id +" has been deleted ");
                   // }
                  //  else{
                    //    throw new ResourceNotFoundException("The post with id "+ id + " could not be deleted");
                    //}
        }

        @PutMapping("editPostById/{id}")
    public ResponseEntity<String> editPostedById(@PathVariable Integer id, Posted_Edit_Dto posted_dto) throws ResourceNotFoundException
        {
            try                     //Este endpoint esta resuelto con try and catch.
            {
                _postedService.editPosted(id, posted_dto);
                return ResponseEntity.ok("Post with id "+ id + "has ben successfull update");
            }
            catch (ResourceNotFoundException e)
            {
                throw new ResourceNotFoundException("Untable to update post with id " + id);
            }
        }
        @GetMapping("getAllPostByUuser/{id}")
    public ResponseEntity<List<Posted>> getAllPosByUuser(@PathVariable Integer id) throws ResourceNotFoundException{



            Uuser myUuser = _uuserService.findByIdUuser(id).orElse(null);

            Optional<Posted> myPostedforUuser = _postedService.findByIdPosted(myUuser.)

        }
}
