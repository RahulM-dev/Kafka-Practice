package com.testKafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.testKafka.payload.User;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "dark-json",groupId = "myConsumerGroup")
	public void consume(User user) {
		LOGGER.info(String.format("Json message receive as -> %s", user.toString()));
	}
}
