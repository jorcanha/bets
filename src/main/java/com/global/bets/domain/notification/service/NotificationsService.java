package com.global.bets.domain.notification.service;

public interface NotificationsService {

	public String preferences(
			String userId,
			Boolean allowContactByPhone,
			Boolean allowContactByMail
	);
}
