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
public class BetsDto {

	private String id;

	private Boolean betWon;

	@NotNull(message = "Bet score cannot be null")
	@JsonProperty(required = true)
	private String betScore;

	@NotNull(message = "Bet Date cannot be null")
	@JsonProperty(required = true)
	private LocalDateTime betDate;

	@NotNull(message = "Event cannot be null")
	@JsonProperty(required = true)
	private String event;

	@NotNull(message = "User cannot be null")
	@JsonProperty(required = true)
	private String user;
}
