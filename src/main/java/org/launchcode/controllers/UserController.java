package org.launchcode.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    public String displayAddUserForm(Model model){
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    @GetMapping
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if(verify.equals(user.getPassword())){
            UserData.add(user);
            return "redirect:/";
        }

        //model.addAttribute(username, user.getUsername());
        //model.addAttribute("email", user.getEmail());
        //model.addAttribute("error", "Error: password and verify password need to match");

        return "user/add";

    }

    @GetMapping
}
