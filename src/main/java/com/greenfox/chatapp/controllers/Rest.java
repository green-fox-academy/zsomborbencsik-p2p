package com.greenfox.chatapp.controllers;

import com.greenfox.chatapp.services.LoggerService;
import com.greenfox.chatapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {

    @Autowired
    UserService userService;

    @Autowired
    LoggerService loggerService;


}
