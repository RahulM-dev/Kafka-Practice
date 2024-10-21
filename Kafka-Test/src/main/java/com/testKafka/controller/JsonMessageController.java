package com.testKafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testKafka.kafka.JsonKafkaProducer;
import com.testKafka.payload.User;

@RestController
@RequestMapping("/json/kafka")
public class JsonMessageController {
	
	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;
	
	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Message Sent");
	}

}
