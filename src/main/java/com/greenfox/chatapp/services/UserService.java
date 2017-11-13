package com.greenfox.chatapp.services;

import com.greenfox.chatapp.model.Userka;
import com.greenfox.chatapp.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService() {
    }

    public List<Userka> getAllUserka() {
        List<Userka> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<Userka> findAllUser() {
        return userRepository.findAll();
    }

    public void addUser(Userka userka) {
        userRepository.save(userka);
    }

    public Userka findUserById (int id) {
        return userRepository.findOne(id);
    }

    public Userka getNewUser() {
        return new Userka();
    }

    public void saveDatabase(Userka user) {
        userRepository.save(user);
    }




}
