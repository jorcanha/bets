package com.global.bets.controller;

import com.global.bets.model.dto.UsersDto;
import com.global.bets.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

	private final UsersService usersService;

	@PostMapping("register")
	@Operation(summary = "")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "", content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)) })
	})
	public ResponseEntity<String> register(@RequestBody UsersDto usersDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usersService.register(usersDto));
	}
}
