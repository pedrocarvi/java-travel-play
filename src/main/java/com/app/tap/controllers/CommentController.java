package com.app.tap.controllers;


import com.app.tap.entitites.Comment;
import com.app.tap.entitites.dtos.Comment_Dto;
import com.app.tap.exceptions.BadRequestException;
import com.app.tap.exceptions.ResourceNotFoundException;
import com.app.tap.service.CommentService;
import com.app.tap.service.mapping.CommentMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService _commentService;

    private CommentMapping _commentMapping;

    @Autowired
    public void setCommentMapping(CommentMapping commentMapping){
        _commentMapping = commentMapping;
    }


    @GetMapping("getAll")
    public ResponseEntity<List> getAllComment() throws ResourceNotFoundException{

        List<Comment> commentsList =_commentService.getAll();

        return ResponseEntity.ok(commentsList);
    }





    @PostMapping("/create")
    public ResponseEntity<Comment> newComment(@RequestBody Comment_Dto comment_dto) throws BadRequestException {

        Comment new_comment = _commentMapping.convertDtoToComment(comment_dto);




        return _commentService.addComment(new_comment);

    }

}
