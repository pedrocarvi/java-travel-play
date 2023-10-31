package com.app.tap.entitites;
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
    private Integer locationX;
    @Column Integer locationY;


}
