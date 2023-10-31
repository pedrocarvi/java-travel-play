package com.app.tap.entitites.dto; 
import com.app.tap.enums.Role;

import java.io.Serializable;

public class Uuser_Dto implements Serializable {

    private String userName;
    private String email;
    private String pssword;
    private String firstName;
    private String lastName;


    // Constructor vacío
    public Uuser_Dto() {

    }

    // Constructor para copiar datos desde una entidad Uuser a UuserDTO
    public Uuser_Dto(String userName, String email,String pssword, String firstName, String lastName, Role userRole) {

        this.userName = userName;
        this.email = email;
        this.pssword = pssword;
        this.firstName = firstName;
        this.lastName = lastName;

    }



    // Getters (no lleva setters)


    public String getUserName() {
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

    public String getPssword() {
        return pssword;
    }

    public void setUserName(String userName) {
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

    public void setPssword(String pssword) { this.pssword = pssword; }
}
