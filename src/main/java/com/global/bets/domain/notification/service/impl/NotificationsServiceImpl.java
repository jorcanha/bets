package com.global.bets.domain.notification.service.impl;

import com.global.bets.domain.notification.service.NotificationsService;
import com.global.bets.model.entity.Users;
import com.global.bets.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationsServiceImpl implements NotificationsService {

	private final UsersRepository usersRepository;

	@Override
	public String preferences(
			String userId,
			Boolean allowContactByPhone,
			Boolean allowContactByMail
	) {
		Optional<Users> user = usersRepository.findById(userId);
		if(user.isPresent()) {
			Users userToUpdate = user.get();
			userToUpdate.setAllowContactByPhone(allowContactByPhone);
			userToUpdate.setAllowContactByMail(allowContactByMail);
			usersRepository.save(userToUpdate);
			log.info("Updated Preferences for user {}", userId);
			return "Updated Preferences";
		} else {
			return "Error updating Preferences";
		}
	}
}
