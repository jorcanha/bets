package com.global.bets.service;

import com.global.bets.model.dto.EventsDto;

public interface EventsService {

	public String create(EventsDto eventsDto);
	public String cancel(String eventId);
}
