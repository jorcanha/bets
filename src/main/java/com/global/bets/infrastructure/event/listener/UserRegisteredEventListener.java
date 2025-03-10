package com.global.bets.infrastructure.event.listener;

import com.global.bets.infrastructure.event.UserRegisteredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRegisteredEventListener {

	@EventListener
	public void handleCustomEvent(UserRegisteredEvent event) {
		log.info("---------------------");
		log.info("---------------------");
		log.info("Listened EventCanceledEvent: {}", event.getMessage());
	}
}
