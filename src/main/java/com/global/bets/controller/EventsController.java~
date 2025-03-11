package com.global.bets.controller;

import com.global.bets.model.dto.EventsDto;
import com.global.bets.service.EventsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventsController {

	private final EventsService eventsService;

	@PostMapping("create")
	@Operation(summary = "")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "", content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)) })
	})
	public ResponseEntity<?> create(EventsDto eventsDto) {
		return ResponseEntity.status(HttpStatus.OK).body(eventsService.create(eventsDto));
	}

	@PostMapping("cancel")
	@Operation(summary = "")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "", content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)) })
	})
	public ResponseEntity<String> cancel(String eventId) {
		return ResponseEntity.status(HttpStatus.OK).body(eventsService.cancel(eventId));
	}

	@GetMapping("favorites")
	@Operation(summary = "")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "", content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)) })
	})
	public ResponseEntity<String> favorites() {
		return ResponseEntity.status(HttpStatus.OK).body(eventsService.favorites());
	}
}
