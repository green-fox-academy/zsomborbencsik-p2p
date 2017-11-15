package com.greenfox.chatapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String username;
    String text;
    Date messageCreated;
    Integer randomId;

    public Message() {
        LocalDate localDate = LocalDate.now();
        this.messageCreated = java.sql.Date.valueOf(localDate);
        this.randomId = (int)(Math.random() * (10000 - 1) + 1) + 1;
    }

    public Message(String text,String username) {
        this.text = text;
        this.username = username;
        this.randomId = (int)(Math.random() * (10000 - 1) + 1) + 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getMessageCreated() {
        return messageCreated;
    }

    public void setMessageCreated(Date messageCreated) {
        this.messageCreated = messageCreated;
    }

    public Integer getRandomId() {
        return randomId;
    }

    public void setRandomId(Integer randomId) {
        this.randomId = randomId;
    }

}
