package com.prowerblog.prowerblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prowerblog.prowerblog.Model.User;
import com.prowerblog.prowerblog.Service.UserService;

import jakarta.validation.Valid;

@Controller
public class SignUpController {
    
    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("RegisterData", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("RegisterData") User user,BindingResult result,Model model){
        if (userService.findByEmail(user.getEmail()).isPresent()) {
         result.rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (userService.findByUsername(user.getUsername()).isPresent()) {
     result.rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }

        if (!result.hasErrors()) {
            userService.signup(user);
            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new User());
        }else{
            return "signup";
        }   
        return "login";
        }
    }
