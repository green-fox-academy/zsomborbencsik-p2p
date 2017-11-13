package com.greenfox.chatapp.controllers;

import com.greenfox.chatapp.model.Userka;
import com.greenfox.chatapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<Userka> getAllUserka () {
        return userService.getAllUserka();
    }

    @RequestMapping("/users/{id}")
    public Userka getUserka (@PathVariable int id) {
        return userService.findUserById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    public void addUserka(@RequestBody Userka userka) {
        userService.addUser(userka);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void updateUserka(@RequestBody Userka userka) {
        userService.updateUserka(userka);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/{id}")
    public void deleteUserka(@PathVariable int id) {
        userService.deleteUserka(id);
    }



}
