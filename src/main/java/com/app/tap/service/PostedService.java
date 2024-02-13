package com.app.tap.service;

import com.app.tap.entitites.Posted;
import com.app.tap.entitites.dtos.Posted_Edit_Dto;
import com.app.tap.exceptions.ResourceNotFoundException;
import com.app.tap.repository.PostedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostedService {

     @Autowired
     PostedRepository _postedRepository;
     private  UuserService _userService;
     private  CommentService _commentService;


     @Autowired
     public void setUserService(UuserService userService){
         _userService = userService;
     }

     @Autowired
     public void setCommentService(CommentService commentService){
         _commentService = commentService;
     }







   // public PostedService(UuserService userService, CommentService commentService) {
   //     _userService = userService;                         // hago una inyección de dependecias de uuserservices.(A LA HORA DE USAR UN SERVICIO DENTRO DE OTRO SERVICIO ES NECESARIO HACER UNA INYECION DE DEPENDECIAS.
   //     _commentService = commentService;
    //}










    public Posted newPosted(Posted _posted){

         Posted the_posted = new Posted();
         the_posted.setPostedId(_posted.getPostedId());
         the_posted.setUuserId(_posted.getUuserId());
         the_posted.setPictured(_posted.getPictured());
         the_posted.setName_posted(_posted.getName_posted());
         the_posted.setDescription(_posted.getDescription());
         List<Integer> listavacia = new ArrayList<>();
         the_posted.setCategory(_posted.getCategory());
         the_posted.setPosted_fav(_posted.getPosted_fav());
         the_posted.setCommentsId(listavacia);
         the_posted.setLocationX(_posted.getLocationX());
         the_posted.setLocationY(_posted.getLocationY());

          return _postedRepository.save(the_posted);  // Cuando se crea un nuevo posteo se busca el Uuser en la Db y se lo asocia en el DTO del posteo.

     }

    public Optional<Posted> findByIdPosted(Integer id){

        return _postedRepository.findById(Long.valueOf(id));    //Tener cuidado, el tipo de dato de la propiedad postedId es Long, y estoy busncando por id,(se esta usando una conversion de datos.

    }

     public List<Posted> getAll() {
        return _postedRepository.findAll();
    }  // Tengo que verificar que en vez de devolver una list de posted sea una list de Posted_Dto.



    public void deletPosted(Integer Id) throws ResourceNotFoundException {

        if(findByIdPosted(Id).isEmpty())
            throw  new ResourceNotFoundException("The post with id "+ Id + " could not be deleted");
        Posted del_Posted = _postedRepository.findById(Long.valueOf(Id)).orElse(null);

        _postedRepository.delete(del_Posted);
    }

    public void editPosted(Integer Id, Posted_Edit_Dto edit_posted_update) throws ResourceNotFoundException{
        if (findByIdPosted(Id).isEmpty())
            throw new ResourceNotFoundException("Post with id: "+ Id +" not found to edit");

        Posted edit_posted = _postedRepository.findById(Long.valueOf(Id)).orElse(null); //Traigo el posteo que tengo que editar

        // aca edito todos los valores del posteo excepto el Id por es el mismo, y el Uuser porque tambien tiene que ser el mismo.

        edit_posted.setPictured(edit_posted_update.getPictured());
        edit_posted.setPicture_fav(edit_posted_update.getPictured_fav());
        edit_posted.setName_posted(edit_posted_update.getName_posted());
        edit_posted.setDescription(edit_posted_update.getDescription());
        edit_posted.setPosted_fav(edit_posted_update.getPosted_fav());
        edit_posted.setCategory(edit_posted_update.getCategory());
        edit_posted.setLocationX(edit_posted_update.getLocationX());
        edit_posted.setLocationY(edit_posted_update.getLocationY());

        //aca tengo que guardarlo en la db
        _postedRepository.save(edit_posted);

        //Corroborar y probar el endpoint para ver que este bien hecho
    }



    public List<Posted> findAllByUserId(Integer userId) {

        return _postedRepository.findAllByUuserId(userId);

    }











   /*  public Posted_Get_Dto convertPostedToDTO(Posted posted){    //Este metodo por lo general lo uso para devolver un posteo.
          Posted_Get_Dto posted_get_dto = new Posted_Get_Dto();

          posted_get_dto.setId(Math.toIntExact(posted.getPostedId()));
          posted_get_dto.setUuser(_userService.convertUuserToUuserGetDTO(posted.getUuser()));  //aca tuve que implementar el serivce de uuser para poder pasar de Uuser a Dto.
          posted_get_dto.setPictured(posted.getPictured());
          posted_get_dto.setPictured_fav(posted.getPicture_fav());
          posted_get_dto.setName_posted(posted.getName_posted());
          posted_get_dto.setDescription(posted.getDescription());

          // aca hay q transformar la lista de comments a comments_get_dto;
         List<Comment_Dto> commentDTOList = new ArrayList<>();
         for (Comment comment : posted.getComments()) {
             Comment_Dto commentDTO = _commentService.converCommentToDto(comment);
             commentDTOList.add(commentDTO);
         }

          posted_get_dto.setComments(commentDTOList); //Esto recibe una lista pero de tipo comments_get_dto.
          posted_get_dto.setLocationX(posted.getLocationX());
          posted_get_dto.setLocationY(posted.getLocationY());

          return posted_get_dto;
     }


     public Posted convertDTOToPosted(Posted_Create_Dto posted_create_dto) {   // Este metodo lo usaria principalmente para crear un posteo, ya que convierto de posted_dto a posted y convierto el uuser_dto a Uuser.

          Posted posted = new Posted();

          Uuser myUuser = _userService.findByIdUuser(posted_create_dto.getUuser_get_dto().getId()).orElse(null); // Mediante el findbyId del Uuser service me traigo el uuser y lo uso para guardarlo en la base de datos.

           posted.setUuser(myUuser);
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

         Uuser myUuser = _userService.findByIdUuser(posted_get_dto.getUuser().getId()).orElse(null);

         posted.setUuser(myUuser);
         posted.setPictured(posted_get_dto.getPictured());
         posted.setPicture_fav(posted_get_dto.getPictured_fav());
         posted.setName_posted(posted_get_dto.getName_posted());
         posted.setDescription(posted_get_dto.getDescription());
         posted.setLocationX(posted_get_dto.getLocationX());
         posted.setLocationY(posted_get_dto.getLocationY());

         return  posted;
     }

    */
}
