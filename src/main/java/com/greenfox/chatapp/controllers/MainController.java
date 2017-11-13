package com.greenfox.chatapp.controllers;


import com.greenfox.chatapp.ErrorMessage;
import com.greenfox.chatapp.model.Userka;
import com.greenfox.chatapp.repositories.UserRepository;
import com.greenfox.chatapp.services.LoggerService;
import com.greenfox.chatapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    LoggerService loggerService;

    @Autowired
    UserRepository userRepository;


    @RequestMapping("/")
    public String getHomepage(Model model) {
        model.addAttribute("listUser", userRepository.findAll());
        return "index";
    }

    @PostMapping("/update")
    public String updateEntry(@ModelAttribute Userka user, Model model){
            model.addAttribute("newUser", user);
        if (user.getName().equals("")) {
            model.addAttribute("errorMessage", "Add username plzzzz");
            return "enter";
        } else if (user.getName().equals("csunyaszo")) {
            model.addAttribute("errorMessage2","Bad bad user");
            return "enter";
        }
        userService.saveDatabase(user);
        return "redirect:/";
    }

    @RequestMapping("/enter")
    public String getEnterPage(Model model) {
    model.addAttribute("newUser", userService.getNewUser());
    return "enter";
    }

    /*@RequestMapping("/enter")
    publd gjidhgjdhgjdlgsgdsic String getEnterPage(Model model) {
        model.addAttribfsfasfsagdsgsdute("newUser", userService.getNewUser());
        return "enter";
    }*/

}
