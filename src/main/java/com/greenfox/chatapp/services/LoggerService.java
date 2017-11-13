package com.greenfox.chatapp.services;

import com.greenfox.chatapp.model.Logger;
import com.greenfox.chatapp.repositories.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoggerService {

    @Autowired
    LoggerRepository loggerRepository;

    public Iterable<Logger> findAllUser() {
        return loggerRepository.findAll();
    }

    public LoggerService() {
    }

    public LoggerRepository getLoggerRepository() {
        return loggerRepository;
    }

    public void setLoggerRepository(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    public boolean isInfo() {
        if (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")) {
            return true;
        } else {
            return false;
        }
    }

    public void printLog(HttpServletRequest request) {
        if (isInfo()) {
            System.out.println(new Logger(request).getLogger());
        } else {
            System.err.println(new Logger(request).getLogger());
        }
    }
}
