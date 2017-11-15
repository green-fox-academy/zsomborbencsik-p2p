package com.greenfox.chatapp.services;

import com.greenfox.chatapp.model.Userka;
import com.greenfox.chatapp.repositories.UserRepository;
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
    public Userka getUserka () {
        return userRepository.findOne(1);
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

    public void updateUserka(Userka userka) {
        userRepository.save(userka);
    }
    public void deleteUserka(int id) {
        userRepository.delete(id);
    }

    public boolean checkIfUsernameIsTaken(String username) {
        for (int i = 0; i < getAllUserka().size(); i++) {
            if (findUserById(i).getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public String getErrormessage(Userka user) {
        if (user.getUserName().equals("")) {
            return "Add username plzzzz";
        } else if (checkIfUsernameIsTaken(user.getUserName())) {
            return "Username is already taken";
        } else if (user.getUserName().equals("csunyaszo")) {
            return "Bad bad user";
        }
        return null;
    }
    public boolean checkIfInputOk (Userka user) {
        if (user.getUserName().equals("") || checkIfUsernameIsTaken(user.getUserName()) || user.getUserName().equals("csunyaszo")) {
            return true;
        }
        return false;
    }
}
