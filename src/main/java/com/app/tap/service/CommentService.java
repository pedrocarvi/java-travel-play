package com.app.tap.service;

import com.app.tap.entitites.Comment;
import com.app.tap.entitites.Posted;
import com.app.tap.entitites.Uuser;
import com.app.tap.repository.CommentRepository;
import com.app.tap.repository.PostedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository _commentRespository;

    private  UuserService _userService;
    private  PostedService _postedService;
    private PostedRepository _postedRepository;


    @Autowired
    public void SetUserService(UuserService uuserService){
        _userService = uuserService;
    }

    @Autowired
    public void SetPostedService(@Lazy PostedService postedService){
        _postedService = postedService;
    }

    @Autowired
    public void SetPostedRepository(PostedRepository postedRepository){_postedRepository =postedRepository;};

  //  public CommentService(UuserService uuserService, PostedService postedService){
   //     _userService = uuserService;
  //      _postedService = postedService;
 //   }








/*
    public Comment_Dto converCommentToDto (Comment comment){
        Comment_Dto comment__dto = new Comment_Dto();
        comment__dto.setCommentId(comment.getCommentId());
        comment__dto.setUuser(_userService.convertUuserToUuserGetDTO(comment.getUuser()));
        comment__dto.setPosted(_postedService.convertPostedToDTO(comment.getPosted()));
        comment__dto.setComment(comment.getThe_comment());

        return comment__dto;
    } */

   /* public Comment convertDtoToComment(Comment_Dto comment_dto){

        Comment comment = new Comment();

        comment.setCommentId(comment_dto.getCommentId());
        comment.setUuser(_userService.findByIdUuser(comment_dto.getUuser().getId()).orElse(null));
        //comment.setPosted(_postedService.convertGetDtoToPosted(comment_dto.getPosted()));
        comment.setThe_comment(comment_dto.getComment());

        return comment;
    } */

    public ResponseEntity<Comment> addComment(Comment comment){

        _commentRespository.save(comment);
         //Guardo el comentario nuevo

        Integer Post_id = comment.getPostedId(); //Traigo el id del al cual le corresponde el comentario.

        //Lo transformo de Long a Integer.


        Posted myPosted = _postedService.findByIdPosted(Post_id).orElse(null); //Busco el posteo al cual le corresponde el comentario a agregar.

        List<Integer> misComentarios = myPosted.getCommentsId(); //Guardo los comentarios del posteo que traje anteriormente en una lista.

        Long thisCommentId = _commentRespository.findLastCommentId();

        Integer thisCommentIdInt = thisCommentId.intValue();

        misComentarios.add(thisCommentIdInt); //Agrego el Id del comentario en la lista del posteo, para que le corresponda al posteo seleccionado.


        myPosted.setCommentsId(misComentarios); //Seteo la propiedad del posteo donde esta aguardado el Id del comentario hecho con el corresponiente posteo.

        _postedRepository.save(myPosted); //Guardo el posteo con la lista de los Id de los comentarios actualizada.
        return ResponseEntity.ok(comment);

    }


    public  List<Comment> getAll(){
        return _commentRespository.findAll();
    }



}
