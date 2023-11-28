package com.prowerblog.prowerblog.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowerblog.prowerblog.Model.Comment;
import com.prowerblog.prowerblog.Model.User;
import com.prowerblog.prowerblog.Repository.CommentRepository;

@Service
public class CommentService {
    
    @Autowired
    CommentRepository commentRepository;

    public Comment save(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    public Optional<Comment> findForId(long id) {
        return commentRepository.findById(id);
    }

    public void delete(Comment comment) {
    }

    public List<Comment> findByUserOrderedByDate(User user) {
        List<Comment> comments = commentRepository.findByUserOrderByCreateDateDesc(user);
         return comments;
    }
}
