package com.prowerblog.prowerblog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prowerblog.prowerblog.Model.Comment;
import com.prowerblog.prowerblog.Model.User;

public interface CommentRepository extends JpaRepository<Comment,Long>{

    List<Comment> findByUserOrderByCreateDateDesc(User user);
    
}
