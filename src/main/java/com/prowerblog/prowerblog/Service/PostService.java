package com.prowerblog.prowerblog.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowerblog.prowerblog.Model.Post;
import com.prowerblog.prowerblog.Repository.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> getallpost(){
        List<Post> allpost = postRepository.findAll();
        return allpost;
    }

    public List<Post> getpostsbyId(long id){
        List<Post> post = postRepository.findAllById(id);
        return post;
    }

    public Optional<Post> findForId(Long id) {
        return postRepository.findById(id);
    }

    public Post save(Post post) {
        return postRepository.saveAndFlush(post);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

}
