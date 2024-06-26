package com.example.TakeHomeAssessment.service;

import com.example.TakeHomeAssessment.domain.Comment;
import com.example.TakeHomeAssessment.error.ResourceNotFoundException;
import com.example.TakeHomeAssessment.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment == null) {
            throw new ResourceNotFoundException("Comment not found");
        }
        return comment;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = getCommentById(id);
        comment.setContent(commentDetails.getContent());
        return commentRepository.save(comment);
    }
}
