package com.prowerblog.prowerblog.Repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prowerblog.prowerblog.Model.Post;
import com.prowerblog.prowerblog.Model.User;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllById(long id);

    Page<Post> findAllByOrderByCreateDateDesc(Pageable pageable);

    List<Post> findByUserOrderByCreateDateDesc(User user);


}
