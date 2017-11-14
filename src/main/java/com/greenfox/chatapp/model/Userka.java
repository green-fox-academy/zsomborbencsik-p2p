package com.greenfox.chatapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Userka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    @ManyToOne
    Message userMessage;

    public Userka(String name) {
        this.name = name;
    }

    public Userka() {
    }

    public int getId() {
        return id;
    }
    public boolean checkIfHasUsername() {
        if (this.name.equals("")) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
