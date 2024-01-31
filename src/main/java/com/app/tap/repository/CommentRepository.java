package com.app.tap.repository;

import com.app.tap.entitites.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT MAX(id) FROM Comment")
    Long findLastCommentId();

}
