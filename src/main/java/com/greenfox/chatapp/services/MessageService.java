package com.greenfox.chatapp.services;

import com.greenfox.chatapp.model.Logger;
import com.greenfox.chatapp.model.Message;
import com.greenfox.chatapp.model.Userka;
import com.greenfox.chatapp.repositories.LoggerRepository;
import com.greenfox.chatapp.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserService userService;

    public Iterable<Message> findAllUser() {
        return messageRepository.findAll();
    }

    public MessageService() {
    }

    public List<Message> findAllMessageByUsername(String username) {
        List<Message> messages = new ArrayList<>();
        messageRepository.findByUsername(username).forEach(messages::add);
        return messages;
    }

    public void deleteMessage(String username,int id) {
        messageRepository.findByUsername(username).remove(id);
    }

    public MessageRepository getMessageRepository() {
        return messageRepository;
    }

    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void saveDatabase(Message message) {
        messageRepository.save(message);
    }
}
