package com.app.tap.service;

import com.app.tap.entitites.Posted;
import com.app.tap.entitites.Uuser;
import com.app.tap.entitites.dtos.Posted_Create_Dto;
import com.app.tap.entitites.dtos.Posted_Get_Dto;
import com.app.tap.repository.PostedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.tap.service.UuserService;

import java.util.List;
import java.util.Optional;

@Service
public class PostedService {

     @Autowired
     PostedRepository _postedRepository;
     UuserService _userService;

     public Posted newPosted(Posted _posted){
          return _postedRepository.save(_posted);
     }


     public List<Posted> getAll() {return _postedRepository.findAll();}  // Tengo que verificar que en vez de devolver una list de posted sea una list de Posted_Dto.

     public Posted_Get_Dto convertPostedToDTO(Posted posted){    //Este metodo por lo general lo uso para devolver un posteo.
          Posted_Get_Dto posted_get_dto = new Posted_Get_Dto();

          posted_get_dto.setId(posted.getPostedId());
          posted_get_dto.setUuser(_userService.convertUuserToUuserGetDTO(posted.getUuser()));  //aca tuve que implementar el serivce de uuser para poder pasar de Uuser a Dto.
          posted_get_dto.setPictured(posted.getPictured());
          posted_get_dto.setPictured_fav(posted.getPicture_fav());
          posted_get_dto.setName_posted(posted.getName_posted());
          posted_get_dto.setDescription(posted.getDescription());
          posted_get_dto.setLocationX(posted.getLocationX());
          posted_get_dto.setLocationY(posted.getLocationY());

          return posted_get_dto;
     }


     public Posted convertDTOToPosted(Posted_Create_Dto posted_create_dto) {   // Este metodo lo usaria principalmente para crear un posteo, ya que convierto de posted_dto a posted y convierto el uuser_dto a Uuser.

          Posted posted = new Posted();

          Uuser myUuser = _userService.findById(posted_create_dto.getUuser_get_dto().getId()).orElse(null); // Mediante el findbyId del Uuser service me traigo el uuser y lo uso para guardarlo en la base de datos.

           posted.setUuser(myUuser);
           posted.setPictured(posted_create_dto.getPictured());
           posted.setPicture_fav(posted_create_dto.getPictured_fav());
           posted.setName_posted(posted_create_dto.getName_posted());
           posted.setDescription(posted_create_dto.getDescription());
           posted.setLocationX(posted_create_dto.getLocationX());
           posted.setLocationY(posted_create_dto.getLocationY());


          return posted;

     }

}
