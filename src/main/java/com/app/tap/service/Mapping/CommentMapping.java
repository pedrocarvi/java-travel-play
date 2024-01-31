package com.app.tap.service.Mapping;

import com.app.tap.entitites.Comment;
import com.app.tap.entitites.dtos.Comment_Dto;
import com.app.tap.service.PostedService;
import com.app.tap.service.UuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CommentMapping {

    private UuserService _userService;
    private PostedMapping _postedMapping;

    @Autowired
    public void SetUserService(UuserService uuserService){
        _userService = uuserService;
    }

    @Autowired
    public void SetPostedMapping(@Lazy PostedMapping postedMapping){
        _postedMapping = postedMapping;
    }



    public Comment_Dto converCommentToDto (Comment comment){
        Comment_Dto comment__dto = new Comment_Dto();
        comment__dto.setCommentId(comment.getCommentId());
        comment__dto.setUuserId(comment.getUuserId());
        //comment__dto.setUuserId(_userService.convertUuserToUuserGetDTO(comment.getUuser()));
        comment__dto.setPostedId(comment.getPostedId());
        //comment__dto.setPosted(_postedMapping.convertPostedToDTO(comment.getPosted()));
        comment__dto.setComment(comment.getThe_comment());

        return comment__dto;
    }


    public Comment convertDtoToComment(Comment_Dto comment_dto){

        Comment comment = new Comment();

        comment.setCommentId(comment_dto.getCommentId());
        comment.setUuserId(comment_dto.getUuserId());

        //comment.setUuser(_userService.findByIdUuser(comment_dto.getUuser().getId()).orElse(null));
        comment.setPostedId(comment_dto.getPostedId());
        //comment.setPosted(_postedMapping.convertGetDtoToPosted(comment_dto.getPosted()));

        comment.setThe_comment(comment_dto.getComment());

        return comment;
    }






}
