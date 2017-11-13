package com.greenfox.chatapp.services;

import com.greenfox.chatapp.model.Logger;
import com.greenfox.chatapp.repositories.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
