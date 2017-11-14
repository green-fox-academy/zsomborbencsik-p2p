package com.greenfox.chatapp.repositories;

import com.greenfox.chatapp.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    public List<Message> findByUsername(String username);
}
