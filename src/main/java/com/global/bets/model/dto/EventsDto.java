package com.global.bets.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventsDto {

	private String id;

	@NotNull(message = "Score cannot be null")
	@JsonProperty(required = true)
	private String score;

	@NotNull(message = "Allow Event name cannot be null")
	@JsonProperty(required = true)
	private String eventName;

	private Boolean isEventActive;
	private LocalDateTime eventDate;
}
