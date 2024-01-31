package com.app.tap.service.Mapping;

import com.app.tap.entitites.Comment;
import com.app.tap.entitites.Posted;
import com.app.tap.entitites.Uuser;
import com.app.tap.entitites.dtos.Comment_Dto;
import com.app.tap.entitites.dtos.Posted_Create_Dto;
import com.app.tap.entitites.dtos.Posted_Get_Dto;
import com.app.tap.service.CommentService;
import com.app.tap.service.UuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostedMapping {

    private UuserService _userService;

    private CommentMapping _commentMapping;

    @Autowired
    public void setUserService(UuserService userService){
        _userService = userService;
    }

    @Autowired
    public void setCommentComment(CommentMapping commentMapping){
        _commentMapping = commentMapping;
    }

    public Posted_Get_Dto convertPostedToDTO(Posted posted){    //Este metodo por lo general lo uso para devolver un posteo.
        Posted_Get_Dto posted_get_dto = new Posted_Get_Dto();

        posted_get_dto.setPostedId(Math.toIntExact(posted.getPostedId()));
        posted_get_dto.setUuserId(posted.getUuserId());
        //posted_get_dto.setUuser(posted.getUuserId());  //aca tuve que implementar el serivce de uuser para poder pasar de Uuser a Dto.

        posted_get_dto.setPictured(posted.getPictured());
        posted_get_dto.setPictured_fav(posted.getPicture_fav());
        posted_get_dto.setName_posted(posted.getName_posted());
        posted_get_dto.setDescription(posted.getDescription());

        // aca hay q transformar la lista de comments a comments_get_dto;
        /*List<Comment_Dto> commentDTOList = new ArrayList<>();
        for (Comment comment : posted.getComments()) {
            Comment_Dto commentDTO = _commentMapping.converCommentToDto(comment);
            commentDTOList.add(commentDTO);
        }*/

        //posted_get_dto.setComments(commentDTOList); //Esto recibe una lista pero de tipo comments_get_dto.

        posted_get_dto.setCommentsId(posted.getCommentsId());
        posted_get_dto.setLocationX(posted.getLocationX());
        posted_get_dto.setLocationY(posted.getLocationY());

        return posted_get_dto;
    }


    public Posted convertDTOToPosted(Posted_Create_Dto posted_create_dto) {   // Este metodo lo usaria principalmente para crear un posteo, ya que convierto de posted_dto a posted y convierto el uuser_dto a Uuser.

        Posted posted = new Posted();

        //Uuser myUuser = _userService.findByIdUuser(posted_create_dto.getUuser_get_dto().getId()).orElse(null); // Mediante el findbyId del Uuser service me traigo el uuser y lo uso para guardarlo en la base de datos.

        posted.setUuserId(posted_create_dto.getUuserId());
        posted.setPictured(posted_create_dto.getPictured());
        posted.setPicture_fav(posted_create_dto.getPictured_fav());
        posted.setName_posted(posted_create_dto.getName_posted());
        posted.setDescription(posted_create_dto.getDescription());
        posted.setLocationX(posted_create_dto.getLocationX());
        posted.setLocationY(posted_create_dto.getLocationY());

        return posted;

    }

    public Posted convertGetDtoToPosted(Posted_Get_Dto posted_get_dto){ //Este lo uso para convertir de get a posted ya que en comment lo necesito para manejarlo en la base de datos, ya que a la hora de cambiar de commnet_dto a comment, necesito cambiar de posted_get_dto a posted.

        Posted posted = new Posted();


        Uuser myUuser = _userService.findByIdUuser(posted_get_dto.getPostedId()).orElse(null);  //esto no lo uso.
        //Uuser myUuser = _userService.findByIdUuser(posted_get_dto.getUuser().getId()).orElse(null);

        posted.setUuserId(posted_get_dto.getUuserId());
        posted.setPictured(posted_get_dto.getPictured());
        posted.setPicture_fav(posted_get_dto.getPictured_fav());
        posted.setName_posted(posted_get_dto.getName_posted());
        posted.setDescription(posted_get_dto.getDescription());
        posted.setLocationX(posted_get_dto.getLocationX());
        posted.setLocationY(posted_get_dto.getLocationY());

        return  posted;
    }


}
