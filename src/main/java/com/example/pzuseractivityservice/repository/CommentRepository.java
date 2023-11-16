package com.example.pzuseractivityservice.repository;

import com.example.pzuseractivityservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findAllByArticleId(UUID id);
    List<Comment> findAllByAuthorId(long id);

}
