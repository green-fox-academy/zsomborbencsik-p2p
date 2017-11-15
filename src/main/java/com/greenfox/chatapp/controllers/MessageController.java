package com.greenfox.chatapp.controllers;

import com.greenfox.chatapp.model.Message;
import com.greenfox.chatapp.model.Status;
import com.greenfox.chatapp.model.Wrapper;
import com.greenfox.chatapp.services.MessageService;
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

    @PostMapping("/api/message/receive")
    @CrossOrigin("*")
    public Object recieveMessage(@RequestBody Wrapper wrapper) {
        if (wrapper.getMessage().getTimestamp() == null || wrapper.getMessage().getUsername() == null || wrapper.getMessage().getText() == null || wrapper.getMessage().getId() == null || wrapper.getClient().getId() == null) {
            return new Status("error", "you fucked up something");
        }
        messageService.saveDatabase(wrapper.getMessage());
        return new Status("ok","");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/messages/{username}/{id}")
    public void deleteUserka(@PathVariable Integer id,@PathVariable String username) {
        messageService.deleteMessage(username,id);
    }
}
