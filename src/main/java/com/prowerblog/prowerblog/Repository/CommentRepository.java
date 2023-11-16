package com.prowerblog.prowerblog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prowerblog.prowerblog.Model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{
    
}
