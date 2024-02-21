package com.app.tap.repository;

import com.app.tap.entitites.Uuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UuserRepository extends JpaRepository<Uuser,Long> {

    @Query("SELECT u FROM Uuser u WHERE u.userName = ?1")
    Optional<Uuser> findByUserName(String userName);  //Esto lo hago para poder implementar spring security


}
