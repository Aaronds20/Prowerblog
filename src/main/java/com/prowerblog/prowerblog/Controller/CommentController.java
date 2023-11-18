package com.prowerblog.prowerblog.Controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prowerblog.prowerblog.Model.Comment;
import com.prowerblog.prowerblog.Model.Post;
import com.prowerblog.prowerblog.Model.User;
import com.prowerblog.prowerblog.Service.CommentService;
import com.prowerblog.prowerblog.Service.PostService;
import com.prowerblog.prowerblog.Service.UserService;

import jakarta.validation.Valid;

@Controller
public class CommentController {
    
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment/{id}")
    public String newComment(@PathVariable("id") long id,Model m,Principal principal){
       Optional<Post> post = postService.findForId(id);
       if (post.isPresent()) {
        Optional<User> user = userService.findByUsername(principal.getName());
        if (user.isPresent()) {
            Comment comment=new Comment();
            comment.setPost(post.get());
            comment.setUser(user.get());
            m.addAttribute("comment", comment);
            return "commentform";
        } else {
            return "error";
        }
       }else{
        return "error";
       }
    }


    @PostMapping("/createcomment")
    public String createComment(@Valid Comment comment,BindingResult result){
        if (result.hasErrors()) {
            return "commentform";
        }
        commentService.save(comment);
        return "redirect:/dashboard/" + comment.getUser().getUsername();
    }
}
