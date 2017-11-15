package com.greenfox.chatapp.model;

import javax.persistence.*;

@Entity
public class Userka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String username;

    @ManyToOne
    Message userMessage;

    public Userka(String username) {
        this.username = username;
    }

    public Userka() {
    }

    public int getId() {
        return id;
    }
    public boolean checkIfHasUsername() {
        if (this.username.equals("")) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
