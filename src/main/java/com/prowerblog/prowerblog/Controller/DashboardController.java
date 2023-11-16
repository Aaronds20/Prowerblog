package com.prowerblog.prowerblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DashboardController {
    @GetMapping("/dashboard/{username}")
    public String dashboard(@PathVariable("username") String username, Model m) {
        m.addAttribute("username", username);
        return "dashboard";
    }
}
