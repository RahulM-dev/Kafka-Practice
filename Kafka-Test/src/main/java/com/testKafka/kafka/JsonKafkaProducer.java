package com.testKafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.testKafka.payload.User;

@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	public void sendMessage(User user) {

		LOGGER.info(String.format("Message sent -> %s", user.toString()));
		Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "dark-json").build();
		kafkaTemplate.send(message);
	}
}
