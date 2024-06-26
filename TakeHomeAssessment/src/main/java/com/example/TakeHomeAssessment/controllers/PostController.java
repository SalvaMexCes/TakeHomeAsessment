package com.example.TakeHomeAssessment.controllers;

import com.example.TakeHomeAssessment.domain.Post;
import com.example.TakeHomeAssessment.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        logger.info("Creating post");
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        logger.info("Getting post by ID: {}", id);
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        logger.info("Getting all posts");
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<List<Post>> getPostByTitle(@RequestParam String title) {
        logger.info("Getting post by title: {}", title);
        return new ResponseEntity<>(postService.getPostByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Long userId) {
        logger.info("Getting posts by user ID: {}", userId);
        return new ResponseEntity<>(postService.getPostsByUserId(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        logger.info("Deleting post with ID: {}", id);
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        logger.info("Updating post with ID: {}", id);
        return new ResponseEntity<>(postService.updatePost(id, postDetails), HttpStatus.OK);
    }
}
