package com.global.bets.infrastructure.event.publisher;

import com.global.bets.infrastructure.event.UserRegisteredEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRegisteredEventPublisher {

	private final ApplicationEventPublisher eventPublisher;

	public void publishEvent(String message) {
		log.info("---------------------");
		log.info("---------------------");
		log.info("Publishing UserRegisteredEvent: {}", message);
		eventPublisher.publishEvent(new UserRegisteredEvent(this, message));
	}
}
