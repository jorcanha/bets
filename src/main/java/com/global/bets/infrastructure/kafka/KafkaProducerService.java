package com.global.bets.infrastructure.kafka;

import com.global.bets.infrastructure.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService implements MessageService {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void sendMessage(String topic, String message) {
		kafkaTemplate.send(topic, message);
	}
}
