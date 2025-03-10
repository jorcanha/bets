package com.global.bets.infrastructure.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
@ToString
public class NewFavoriteEvent extends ApplicationEvent {

	private String message;

	public NewFavoriteEvent(Object source, String message) {
		super(source);
		this.message = message;
	}
}
