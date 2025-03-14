package com.global.bets.service.impl;

import com.global.bets.infrastructure.MessageService;
import com.global.bets.model.dto.EventsDto;
import com.global.bets.model.entity.Events;
import com.global.bets.repository.EventsRepository;
import com.global.bets.service.EventsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventsServiceImpl implements EventsService {

	private final EventsRepository eventsRepository;
	private final MessageService messageService;

	@Value("${kafka.topic.event-updates}")
	private String topic;

	@Override
	public String create(EventsDto eventsDto) {
		Events event = Events
				.builder()
				.score(eventsDto.getScore())
				.eventName(eventsDto.getEventName())
				.isEventActive(true)
				.eventDate(LocalDateTime.now())
				.build();
		eventsRepository.save(event);
		return "Event created";
	}

	@Override
	public String cancel(String eventId) {
		log.info("Cancelling event: {}", eventId);
		Optional<Events> event = eventsRepository.findById(eventId);
		if(event.isPresent()) {
			Events eventUpdate = event.get();
			eventUpdate.setIsEventActive(false);
			eventsRepository.save(eventUpdate);
			messageService.sendMessage(topic, "EventCancelled " + eventId);
			return "Event canceled";
		} else {
			log.error("Error canceling event {}", eventId);
			return "Error canceling event";
		}
	}
}
