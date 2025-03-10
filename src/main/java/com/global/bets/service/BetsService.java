package com.global.bets.service;

import com.global.bets.model.dto.BetsDto;

public interface BetsService {

	public String win(BetsDto betsDto);
	public String lose(BetsDto betsDto);
}
