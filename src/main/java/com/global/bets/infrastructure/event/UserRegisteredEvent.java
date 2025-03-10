package com.global.bets.infrastructure.event;

import lombok.*;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
@ToString
public class UserRegisteredEvent extends ApplicationEvent {

	private String message;

	public UserRegisteredEvent(Object source, String message) {
		super(source);
		this.message = message;
	}
}
