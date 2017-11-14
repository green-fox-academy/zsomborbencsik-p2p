package com.greenfox.chatapp.controllers;

import com.greenfox.chatapp.model.Message;
import com.greenfox.chatapp.model.Userka;
import com.greenfox.chatapp.services.MessageService;
import com.greenfox.chatapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/messages/{username}")
    public List<Message> getAllMessagesByUsername (@PathVariable String username) {
        return messageService.findAllMessageByUsername(username);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/messages/{username}/{id}")
    public void deleteUserka(@PathVariable int id,@PathVariable String username) {
        messageService.deleteMessage(username,id);
    }


}
