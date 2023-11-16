package com.prowerblog.prowerblog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowerblog.prowerblog.Model.Comment;
import com.prowerblog.prowerblog.Repository.CommentRepository;

@Service
public class CommentService {
    
    @Autowired
    CommentRepository commentRepository;

    public Comment save(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }
}
