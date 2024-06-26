package com.example.TakeHomeAssessment.controllers;

import com.example.TakeHomeAssessment.domain.Comment;
import com.example.TakeHomeAssessment.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {


    @Autowired
    private CommentService commentService;

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        logger.info("Creating comment");
        return new ResponseEntity<>(commentService.createComment(comment), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        logger.info("Getting comment by ID: {}", id);
        return new ResponseEntity<>(commentService.getCommentById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        logger.info("Getting all comments");
        return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long postId) {
        logger.info("Getting comments by post ID: {}", postId);
        return new ResponseEntity<>(commentService.getCommentsByPostId(postId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        logger.info("Deleting comment with ID: {}", id);
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment commentDetails) {
        logger.info("Updating comment with ID: {}", id);
        return new ResponseEntity<>(commentService.updateComment(id, commentDetails), HttpStatus.OK);
    }
}
