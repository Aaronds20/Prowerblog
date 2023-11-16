package com.prowerblog.prowerblog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prowerblog.prowerblog.Model.Post;
import com.prowerblog.prowerblog.Service.PostService;

@Controller
public class HomeController {
    
    @Autowired
    PostService postService;

     @GetMapping("/")
    public String homepage(Model m){
        List<Post> allposts = postService.getallpost();
        m.addAttribute("Posts", allposts);
        return "index";
    }
}
