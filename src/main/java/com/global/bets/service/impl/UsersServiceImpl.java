package com.global.bets.service.impl;

import com.global.bets.infrastructure.event.publisher.UserRegisteredEventPublisher;
import com.global.bets.model.dto.UsersDto;
import com.global.bets.model.entity.Users;
import com.global.bets.repository.UsersRepository;
import com.global.bets.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

	private final UsersRepository usersRepository;
	private final UserRegisteredEventPublisher userRegisteredEventPublisher;

	public String register(UsersDto usersDto) {
		Users user = Users
				.builder()
				.firstName(usersDto.getFirstName())
				.lastName(usersDto.getLastName())
				.phone(usersDto.getPhone())
				.mail(usersDto.getMail())
				.allowContactByPhone(usersDto.getAllowContactByPhone())
				.allowContactByMail(usersDto.getAllowContactByMail())
				.build();
		log.info("Registering user on Database: {}", user.getFirstName());
		usersRepository.save(user);
		userRegisteredEventPublisher.publishEvent("UserRegisteredEvent: " + user.getFirstName());
		return "Register";
	}
}
