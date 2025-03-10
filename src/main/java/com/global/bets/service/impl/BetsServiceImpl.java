package com.global.bets.service.impl;

import com.global.bets.infrastructure.MessageService;
import com.global.bets.model.dto.BetsDto;
import com.global.bets.model.entity.Bets;
import com.global.bets.model.entity.Events;
import com.global.bets.model.entity.Users;
import com.global.bets.repository.BetsRepository;
import com.global.bets.repository.EventsRepository;
import com.global.bets.repository.UsersRepository;
import com.global.bets.service.BetsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BetsServiceImpl implements BetsService {

	private final BetsRepository betsRepository;
	private final EventsRepository eventsRepository;
	private final UsersRepository usersRepository;
	private final MessageService messageService;

	@Value("${kafka.topic.bet-events}")
	private String topic;

	@Override
	public String win(BetsDto betsDto) {
		Bets bets = Bets
				.builder()
				.betWon(true)
				.betScore(betsDto.getBetScore())
				.betDate(LocalDateTime.now())
				.users(getUser(betsDto.getUser()))
				.events(getEvent(betsDto.getEvent()))
				.build();
		betsRepository.save(bets);
		messageService.sendMessage(topic, "BetEvents Bet Won with score "  + betsDto.getBetScore());
		return "Win";
	}

	@Override
	public String lose(BetsDto betsDto) {
		Bets bets = Bets
				.builder()
				.betWon(false)
				.betScore(betsDto.getBetScore())
				.betDate(LocalDateTime.now())
				.users(getUser(betsDto.getUser()))
				.events(getEvent(betsDto.getEvent()))
				.build();
		betsRepository.save(bets);
		messageService.sendMessage(topic, "BetEvents Bet Lost with score "  + betsDto.getBetScore());
		return "lose";
	}

	private Users getUser(String id) {
		Optional<Users> user = usersRepository.findById(id);
		if(user.isPresent()) {
			log.info("User: {} found", id);
			return user.get();
		} else {
			log.error("User {} not found", id);
			throw new RestClientException("User not found");
		}
	}

	private Events getEvent(String id) {
		Optional<Events> event = eventsRepository.findById(id);
		if(event.isPresent()) {
			log.info("Event: {} found", id);
			return event.get();
		} else {
			log.error("Event {} not found", id);
			throw new RestClientException("Event not found");
		}
	}
}
