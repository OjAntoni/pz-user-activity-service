package com.example.pzuseractivityservice.web;

import com.example.pzuseractivityservice.model.Comment;
import com.example.pzuseractivityservice.service.CommentService;
import com.example.pzuseractivityservice.web.dto.CommentDto;
import com.example.pzuseractivityservice.web.mapper.CommentMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
@AllArgsConstructor
public class CommentResource {
    private CommentService commentService;
    private CommentMapper commentMapper;

    @GetMapping
    public ResponseEntity<?> getCommentByPostId(@RequestParam UUID postId){
        List<Comment> all = commentService.getAll(postId);
        return ResponseEntity.ok(all);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getCommentsForUser(@RequestParam UUID userId){
        List<Comment> all = commentService.getAllForUser(userId);
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity<?> saveNewComment(@RequestBody CommentDto dto){
        Comment save = commentService.save(commentMapper.toEntity(dto));
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@RequestBody CommentDto dto, @PathVariable UUID id){
        Comment update = commentService.update(id, commentMapper.toEntity(dto));
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable UUID id){
        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
