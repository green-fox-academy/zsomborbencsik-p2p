package com.greenfox.chatapp.services;

import com.greenfox.chatapp.model.Logger;
import com.greenfox.chatapp.model.Message;
import com.greenfox.chatapp.repositories.LoggerRepository;
import com.greenfox.chatapp.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public Iterable<Message> findAllUser() {
        return messageRepository.findAll();
    }

    public MessageService() {
    }

    public MessageRepository getMessageRepository() {
        return messageRepository;
    }

    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
}
