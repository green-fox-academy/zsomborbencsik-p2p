package com.greenfox.chatapp.model;

import javax.persistence.*;

@Entity
public class Userka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String userName;

    @ManyToOne
    Message userMessage;

    public Userka(String userName) {
        this.userName = userName;
    }

    public Userka() {
    }

    public int getId() {
        return id;
    }
    public boolean checkIfHasUsername() {
        if (this.userName.equals("")) {
            return false;
        }
        return true;
    }

    public Message getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(Message userMessage) {
        this.userMessage = userMessage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
