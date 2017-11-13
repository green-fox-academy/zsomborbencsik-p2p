package com.greenfox.chatapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String path;
    String method;
    String date;
    String logLevel;
    String requestData;

    public Logger() {
    }

    public Logger(HttpServletRequest request){
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
        this.path = request.getServletPath();
        this.method = request.getMethod();
        this.requestData = request.getQueryString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }

    public String getLogger() {
        StringBuilder sb = new StringBuilder();
        sb.append(date).append(" ")
                .append(logLevel).append(" ")
                .append(path).append(" ")
                .append(method).append(" ")
                .append(method);
        return sb.toString();
    }
}
