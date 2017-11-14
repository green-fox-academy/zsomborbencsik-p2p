package com.greenfox.chatapp.services;

import com.greenfox.chatapp.ChatappApplication;
import com.greenfox.chatapp.model.*;
import com.greenfox.chatapp.repositories.LoggerRepository;
import com.greenfox.chatapp.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Holder;
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

    public void deleteMessage(String username,Integer id) {
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

    public Status sendMessage(Message message, Client client) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Wrapper> request = new HttpEntity<>(new Wrapper(message,client));
        Status response = restTemplate.postForObject(ChatappApplication.CHAT_APP_PEER_ADDRESS, request, Status.class);
        return response;
    }
}
