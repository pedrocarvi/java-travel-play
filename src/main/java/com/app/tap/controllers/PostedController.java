package com.app.tap.controllers;


import com.app.tap.entitites.Posted;
import com.app.tap.entitites.dtos.Posted_Create_Dto;
import com.app.tap.entitites.dtos.Posted_Get_Dto;
import com.app.tap.exceptions.BadRequestException;
import com.app.tap.exceptions.ResourceNotFoundException;
import com.app.tap.service.PostedService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posted")
public class PostedController {

        @Autowired
        PostedService _postedService;

        @PostMapping("/create")
        public ResponseEntity<Posted> newPosted(@RequestBody Posted_Create_Dto posted_dto) throws BadRequestException {

               Posted new_posted =  _postedService.convertDTOToPosted(posted_dto);           //Mapeo el dto a posteo y lo guardo en variable.
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

                Posted_Get_Dto get_posted_dto = _postedService.convertPostedToDTO(get_posted);

                return  ResponseEntity.ok(get_posted_dto);
        }

        @DeleteMapping("deletById/{id}")
    public ResponseEntity<String> deletPosted(@PathVariable Integer id ) throws ResourceNotFoundException{


        }

}
