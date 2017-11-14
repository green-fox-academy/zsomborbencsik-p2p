package com.greenfox.chatapp.model;

public class Status {
    String status;
    String message;

    public Status() {
    }
    public Status(String status,String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
