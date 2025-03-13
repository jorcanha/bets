package com.global.bets.service;

import com.global.bets.model.dto.BetsDto;

public interface BetsService {

	String win(BetsDto betsDto);
	String lose(BetsDto betsDto);
}
