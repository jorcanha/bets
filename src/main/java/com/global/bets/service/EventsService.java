package com.global.bets.service;

import com.global.bets.model.dto.EventsDto;

public interface EventsService {

	String create(EventsDto eventsDto);
	String cancel(String eventId);
}
