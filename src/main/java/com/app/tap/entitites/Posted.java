package com.app.tap.entitites;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Posted {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long postedId;
    //@ManyToOne
    //@JoinColumn(name = "userName")
    //private Uuser uuser;
    @Column
    private Integer UuserId;
    @Column
    private List<String> pictured;
    @Column
    private String pictured_fav;
    @Column
    private String name_posted;
    @Column
    private String description;
    //@OneToMany(mappedBy = "posted" , cascade = CascadeType.ALL)
    //private List<Comment> comments;
    @Column
    private Boolean posted_fav;
    @Column
    private String category;
    @Column
    private List<Integer> commentsId;

    @Column
    private String locationX;        // Hay que cambiar el tipo de dato de String a Location para poder usar google maps.
    @Column
    private String locationY;



    public Posted() {

    }

    public Posted(Long postedId, Integer uuserId, List<String> pictured, String pictured_fav, String name_posted, String description, Boolean posted_fav, String category, List<Integer> commentsId, String locationX, String locationY) {
        this.postedId = postedId;
        UuserId = uuserId;
        this.pictured = pictured;
        this.pictured_fav = pictured_fav;
        this.name_posted = name_posted;
        this.description = description;
        this.posted_fav = posted_fav;
        this.category = category;
        this.commentsId = commentsId;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public Long getPostedId() {
        return postedId;
    }

    public void setPostedId(Long postedId) {
        this.postedId = postedId;
    }

    public Integer getUuserId() {
        return UuserId;
    }

    public void setUuserId(Integer uuserId) {
        UuserId = uuserId;
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

    public Boolean getPosted_fav() {
        return posted_fav;
    }

    public void setPosted_fav(Boolean posted_fav) {
        this.posted_fav = posted_fav;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
