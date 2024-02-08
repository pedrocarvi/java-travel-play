package com.app.tap.repository;

import com.app.tap.entitites.Posted;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostedRepository extends JpaRepository<Posted,Long> {



    @Query(value = "SELECT * FROM Posted p WHERE p.uuser_id = ?1", nativeQuery = true)
    List<Posted> findAllByUuserId(Integer UuserId);


   // List<Posted> findAllByUuserId(Integer UuserId);

}
