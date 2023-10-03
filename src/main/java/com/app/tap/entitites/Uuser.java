package com.app.tap.entitites;
import jakarta.persistence.*;
@Entity
public class Uuser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer userId;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String pssword;
    @Column
    private String firstName;
    @Column
    private String lastName;

    public Uuser(String alfon, String mail, String number, String alfonso, String garay) {
    }
//    @OneToOne
//    @JoinColumn(name = "role_id")
//    private Rol role;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return pssword;
    }

    public void setPassword(String password) {
        this.pssword = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Rol getRole() {
//        return role;                  REPLANTEAR EL ROL COMO UN ENUM NO COMO UNA ENTIDAD NUEVA.
//    }
//
//    public void setRole(Rol role) {
//        this.role = role;
//    }
}
