package com.greenfox.chatapp.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Userka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;


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
