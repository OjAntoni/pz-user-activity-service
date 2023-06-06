package com.example.pzuseractivityservice.service;

import com.example.pzuseractivityservice.model.Comment;
import com.example.pzuseractivityservice.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CommentService {
    private CommentRepository commentRepository;

    public Comment save(Comment c){
        c.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(c);
    }

    public Comment update(UUID id, Comment c){
        Comment comment = commentRepository.findById(id).orElse(null);
        if(comment == null) return null;
        comment.setContent(c.getContent());
        commentRepository.save(comment);
        return comment;
    }

    public void delete(UUID id){
        commentRepository.deleteById(id);
    }

    public List<Comment> getAll(UUID articleId){
        return commentRepository.findAllByArticleId(articleId);
    }
}
