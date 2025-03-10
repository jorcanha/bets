package com.global.bets.infrastructure.event.listener;

import com.global.bets.infrastructure.event.NewFavoriteEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NewFavoriteEventListener {

	@EventListener
	public void handleCustomEvent(NewFavoriteEvent event) {
		log.info("---------------------");
		log.info("---------------------");
		log.info("Listened NewFavoriteEvent: {}", event.getMessage());
	}
}
