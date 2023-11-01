package com.app.tap.repository;

import com.app.tap.entitites.Posted;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostedRepository extends JpaRepository<Posted,Long> {

        //Los metodos se extienden desde JpaRepository y maneja toda la db.
}
