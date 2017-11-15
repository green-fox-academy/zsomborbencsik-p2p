package com.greenfox.chatapp.controllers;


import com.greenfox.chatapp.model.Message;
import com.greenfox.chatapp.model.Userka;
import com.greenfox.chatapp.repositories.MessageRepository;
import com.greenfox.chatapp.services.LoggerService;
import com.greenfox.chatapp.services.MessageService;
import com.greenfox.chatapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    LoggerService loggerService;

    @Autowired
    MessageService messageService;

    @Autowired
    MessageRepository messageRepository;


    @RequestMapping("/")
    public String getHomepage(Model model, HttpServletRequest request) {
        loggerService.printLog(request);
        model.addAttribute("user", userService.findUserById(1));
        model.addAttribute("newMessage", new Message());
        model.addAttribute("messages", messageRepository.findAll());
        return "index";
    }

    @PostMapping("/addUser")
    public String updateEntry(@ModelAttribute Userka user, Model model, HttpServletRequest request){
        loggerService.printLog(request);
        if (userService.checkIfInputOk(user)) {
            model.addAttribute("newUser",user);
            model.addAttribute("errorMessage", userService.getErrormessage(user));
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

    @PostMapping("/updateUserName")
    public String updateUsername(@ModelAttribute Userka user, HttpServletRequest request) {
        loggerService.printLog(request);
        userService.updateUserka(user);
        return "redirect:/";
    }

    @PostMapping("/addMessage")
    public String addMessage(@ModelAttribute Message message, Model model) {
        messageService.saveDatabase(message);
        return "redirect:/";
    }

    @PostMapping("/messages/send")
    public String sendMessage(@ModelAttribute Message message) {
        message.setUsername("Atomceruza");
        messageService.saveDatabase(message);
        messageService.sendMessage(message);
        return "redirect:/";
    }
}
