package com.app.tap.entitites.dtos;
import com.app.tap.enums.Role;

import java.io.Serializable;

public class Uuser_Get_Dto implements Serializable {

    private Integer Id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;


    // Constructor vacío
    public Uuser_Get_Dto() {

    }

    // Constructor para copiar datos desde una entidad Uuser a UuserDTO
    public Uuser_Get_Dto(Integer Id, String userName, String email, String firstName, String lastName, Role userRole) {

        this.Id = Id;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;

    }



    // Getters (no lleva setters)

    public Integer getId() { return Id; }
    public String getUuserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



    public void setId(Integer Id){
        this.Id = Id;
    }
    public void setUuserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
