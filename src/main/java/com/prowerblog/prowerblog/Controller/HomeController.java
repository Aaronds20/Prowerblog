package com.prowerblog.prowerblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prowerblog.prowerblog.Model.Post;
import com.prowerblog.prowerblog.Service.PostService;
import com.prowerblog.prowerblog.Util.Pager;

@Controller
public class HomeController {
    
    @Autowired
    PostService postService;

     @GetMapping("/")
    public String homepage(@RequestParam(defaultValue = "0") int page,Model model) {

        Page<Post> posts = postService.findAllOrderedByDatePageable(page);
        Pager pager = new Pager(posts);

        model.addAttribute("pager", pager);
        return "index";
    }
}
