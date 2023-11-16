package com.prowerblog.prowerblog.Controller;


import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.prowerblog.prowerblog.Model.Post;
import com.prowerblog.prowerblog.Model.User;
import com.prowerblog.prowerblog.Service.PostService;
import com.prowerblog.prowerblog.Service.UserService;

import jakarta.validation.Valid;

@Controller
public class PostController {
    
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/addpost")
    public String createpost(Model m,Principal principal){
        Optional<User> user = userService.findByUsername(principal.getName());

        if (user.isPresent()) {
            Post post = new Post();
            post.setUser(user.get());
            m.addAttribute("post", post);
            return "postForm";
        } else {
            return "error";
        }
    }

    @PostMapping("/addpost")
    public String createpost(@Valid Post post,BindingResult bindingResult){
            if (bindingResult.hasErrors()) {
                return "postform";
            }
            postService.save(post);
            return "redirect:/dashboard/" + post.getUser().getUsername();
    }
}
