package com.greenfox.chatapp.services;

import com.greenfox.chatapp.model.*;
import com.greenfox.chatapp.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public boolean checkIfInputOk(Wrapper wrapper) {
        if ((wrapper.getMessage().getMessageCreated() == null || wrapper.getMessage().getUsername() == null || wrapper.getMessage().getText() == null || wrapper.getMessage().getId() == null || wrapper.getClient().getId() == null)) {
            return false;
        }
        return true;
    }

    public void saveDatabase(Message message) {
        messageRepository.save(message);
    }

    public Status sendMessage(Message message) {
        RestTemplate template = new RestTemplate();
        String url = "https://pkrisz0chatapp.herokuapp.com/api/message/receive";
        Wrapper sendIt = new Wrapper(message, new Client());
        HttpEntity<Wrapper> httpEntity = new HttpEntity<>(sendIt);
        Status response = template.postForObject(url, httpEntity, Status.class);
        return response;
    }
}
