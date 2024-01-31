package com.app.tap.entitites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Comment {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private Long commentId;
    //@ManyToOne
    //@NotNull
    //@JoinColumn(name = "userId")
    //Uuser uuser;

    @Column
    private Integer uuserId;
    //@ManyToOne
    //@JoinColumn(name = "postedId")
    //private Posted posted;
    @Column
    private Integer postedId;
    @Column
    private String the_comment;

    public Comment() {

    }

    public Comment(Long commentId, Integer uuserId,Integer postedId, String the_comment) {
        this.commentId = commentId;
        this.uuserId = uuserId;
        this.postedId = postedId;
        this.the_comment = the_comment;
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

    public Integer getPostedId() {
        return postedId;
    }

    public void setPostedId(Integer postedId) {
        this.postedId = postedId;
    }

    public String getThe_comment() {
        return the_comment;
    }

    public void setThe_comment(String the_comment) {
        this.the_comment = the_comment;
    }
}
