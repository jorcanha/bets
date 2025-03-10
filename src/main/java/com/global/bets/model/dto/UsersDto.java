package com.global.bets.model.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
public class UsersDto {

	@JsonProperty
	private String id;

	@NotNull(message = "First nane cannot be null")
	@JsonProperty(required = true)
	private String firstName;

	@NotNull(message = "Last nane cannot be null")
	@JsonProperty(required = true)
	private String lastName;

	@NotNull(message = "Phone cannot be null")
	@JsonProperty(required = true)
	private String phone;

	@NotNull(message = "Mail cannot be null")
	@JsonProperty(required = true)
	private String mail;

	@NotNull(message = "Allow Contact By Phone cannot be null")
	@JsonProperty(required = true)
	private Boolean allowContactByPhone;

	@NotNull(message = "Allow Contact By Mail cannot be null")
	@JsonProperty(required = true)
	private Boolean allowContactByMail;
}
