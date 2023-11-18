package com.prowerblog.prowerblog.Controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String createpost(Model m, Principal principal) {
        Optional<User> user = userService.findByUsername(principal.getName());

        if (user.isPresent()) {
            Post post = new Post();
            post.setUser(user.get());
            m.addAttribute("post", post);
            return "postform";
        } else {
            return "error";
        }
    }

    @PostMapping("/addpost")
    public String createpost(@Valid Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "postform";
        }
        postService.save(post);
        return "redirect:/dashboard/" + post.getUser().getUsername();
    }

    @GetMapping("/editpost/{id}")
    public String editpost(@PathVariable("id") long id, Model m, Principal principal) {
        Optional<Post> userpost = postService.findForId(id);
        if (userpost.isPresent()) {
            Post post = userpost.get();
            if (isPrincipalOwnerOfPost(principal, post)) {
                m.addAttribute("post", userpost);
                return "edit_postform";
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }

    @DeleteMapping("/deletepost/{id}")
    public String deletepost(@PathVariable("id") long id, Principal principal) {
        Optional<Post> userpost = postService.findForId(id);
        if (userpost.isPresent()) {
            Post post = userpost.get();
            if (isPrincipalOwnerOfPost(principal, post)) {
                postService.delete(post);
             return "redirect:/dashboard/" + post.getUser().getUsername();
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }

    @GetMapping("/getfullpost/{id}")
    public String FullPost(@PathVariable("id") long id, Model m) {
        Optional<Post> postOptional = postService.findForId(id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            m.addAttribute("fullpost", post);
            return "post";
        } else {
            return "error";
        }
    }

    private boolean isPrincipalOwnerOfPost(Principal principal, Post post) {
        return principal != null && principal.getName().equals(post.getUser().getUsername());
    }

}
