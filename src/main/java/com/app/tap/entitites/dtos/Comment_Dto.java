package com.app.tap.entitites.dtos;

import java.io.Serializable;

public class Comment_Dto implements Serializable {

    private Long commentId;

    private Integer uuserId;

    private String comment;

    private Integer postedId;


    public Comment_Dto() {

    }

    public Comment_Dto(Long commentId, Integer uuserId, String comment, Integer postedId) {
        this.commentId = commentId;
        this.uuserId = uuserId;
        this.comment = comment;
        this.postedId = postedId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Integer getUuserId() {
        return uuserId;
    }

    public void setUuserId(Integer uuserId) {
        this.uuserId = uuserId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getPostedId() {
        return postedId;
    }

    public void setPostedId(Integer postedId) {
        this.postedId = postedId;
    }
}
