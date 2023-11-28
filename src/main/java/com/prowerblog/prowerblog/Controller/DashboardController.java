package com.prowerblog.prowerblog.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prowerblog.prowerblog.Model.Comment;
import com.prowerblog.prowerblog.Model.Post;
import com.prowerblog.prowerblog.Model.User;
import com.prowerblog.prowerblog.Service.CommentService;
import com.prowerblog.prowerblog.Service.PostService;
import com.prowerblog.prowerblog.Service.UserService;

@Controller
public class DashboardController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired 
    private CommentService commentService;

    @GetMapping("/dashboard/{username}")
    public String dashboard(@PathVariable("username") String username, Model m) {
       Optional<User> op_user = userService.findByUsername(username);
       if (op_user.isPresent()) {
           User user=op_user.get();
            List<Post> posts = postService.findByUserOrderedByDate(user);
            List<Comment> comments = commentService.findByUserOrderedByDate(user);
            m.addAttribute("User", user);
            m.addAttribute("Posts", posts);
             m.addAttribute("Comments", comments);
            return "dashboard";
       }else{
        return "error";
       }
        
    }
}
