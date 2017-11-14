package com.greenfox.chatapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatappApplication{

	public static String CHAT_APP_PEER_ADDRESS = System.getenv("CHAT_APP_PEER_ADDRESS");
	public static String CHAT_APP_UNIQUE_ID = System.getenv("CHAT_APP_UNIQUE_ID");

	public static void main(String[] args) {
		SpringApplication.run(ChatappApplication.class, args);

	}

}
