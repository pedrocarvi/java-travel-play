package com.app.tap.entitites.dtos;

import java.io.Serializable;
import java.util.List;

public class Posted_Get_Dto implements Serializable {

    private Integer postedId;
    private Integer UuserId;
    private List<String> pictured;
    private String pictured_fav;
    private String name_posted;
    private String description;
    private List<Integer> commentsId;
    private String locationX;
    private String locationY;



    public Posted_Get_Dto(){

    }

    public Posted_Get_Dto(Integer postedId, Integer uuserId, List<String> pictured, String pictured_fav, String name_posted, String description, List<Integer> commentsId, String locationX, String locationY) {
        this.postedId = postedId;
        this.UuserId = uuserId;
        this.pictured = pictured;
        this.pictured_fav = pictured_fav;
        this.name_posted = name_posted;
        this.description = description;
        this.commentsId = commentsId;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public Integer getPostedId() {
        return postedId;
    }

    public void setPostedId(Integer postedId) {
        this.postedId = postedId;
    }

    public Integer getUuserId() {
        return UuserId;
    }

    public void setUuserId(Integer uuserId) {
        this.UuserId = uuserId;
    }

    public List<String> getPictured() {
        return pictured;
    }

    public void setPictured(List<String> pictured) {
        this.pictured = pictured;
    }

    public String getPictured_fav() {
        return pictured_fav;
    }

    public void setPictured_fav(String pictured_fav) {
        this.pictured_fav = pictured_fav;
    }

    public String getName_posted() {
        return name_posted;
    }

    public void setName_posted(String name_posted) {
        this.name_posted = name_posted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(List<Integer> commentsId) {
        this.commentsId = commentsId;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }
}
