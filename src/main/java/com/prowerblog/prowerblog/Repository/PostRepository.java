package com.prowerblog.prowerblog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prowerblog.prowerblog.Model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllById(long id);
}
