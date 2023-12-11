package com.prowerblog.prowerblog.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prowerblog.prowerblog.Model.Post;
import com.prowerblog.prowerblog.Model.User;
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

    public void delete(Post userpost) {
        postRepository.delete(userpost);
    }

    public List<Post> findByUserOrderedByDate(User user){
         List<Post> posts = postRepository.findByUserOrderByCreateDateDesc(user);
         return posts;
    }
    
    public Page<Post> findAllOrderedByDatePageable(int page) {
    return postRepository.findAll(PageRequest.of(subtractPageByOne(page), 4, Sort.by(Sort.Direction.DESC, "createDate")));
}

    private int subtractPageByOne(int page){
        return (page < 1) ? 0 : page - 1;
    }
}
