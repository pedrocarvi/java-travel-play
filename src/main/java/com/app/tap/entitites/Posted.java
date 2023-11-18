package com.app.tap.entitites;
import com.app.tap.entitites.dtos.Uuser_Get_Dto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Posted {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private Integer postedId;
    @OneToOne
    @JoinColumn
    private Uuser uuser;
    @Column
    private List<String> pictured;
    @Column
    private String picture_fav;
    @Column
    private String name_posted;
    @Column
    private String description;
    @Column
    private String locationX;        // Hay que cambiar el tipo de dato de String a Location para poder usar google maps.
    @Column String locationY;

    public Integer getPostedId() {
        return postedId;
    }

    public void setPostedId(Integer postedId) {
        this.postedId = postedId;
    }

    public Uuser getUuser() {
        return uuser;
    }

    public void setUuser(Uuser uuser) {
        this.uuser = uuser;
    }

    public List<String> getPictured() {
        return pictured;
    }

    public void setPictured(List<String> pictured) {
        this.pictured = pictured;
    }

    public String getPicture_fav() {
        return picture_fav;
    }

    public void setPicture_fav(String picture_fav) {
        this.picture_fav = picture_fav;
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
