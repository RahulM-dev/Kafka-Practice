package com.testKafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
	
	@Bean
	public NewTopic createNewTopic() {
		return TopicBuilder.name("dark").build();
	}
	
	@Bean
	public NewTopic createNewJsonTopic() {
		return TopicBuilder.name("dark-json").build();
	}

}
