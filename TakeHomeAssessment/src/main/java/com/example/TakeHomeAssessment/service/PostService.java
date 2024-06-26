package com.example.TakeHomeAssessment.service;

import com.example.TakeHomeAssessment.domain.Post;
import com.example.TakeHomeAssessment.error.ResourceNotFoundException;
import com.example.TakeHomeAssessment.repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new ResourceNotFoundException("Post not found");
        }
        return post;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public Post updatePost(Long id, Post postDetails) {
        Post post = getPostById(id);
        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());
        return postRepository.save(post);
    }
}
