package com.global.bets.domain.notification.controller;

import com.global.bets.domain.notification.service.NotificationsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationsController {

	private final NotificationsService notificationsService;

	@PutMapping("preferences")
	@Operation(summary = "")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "", content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)) })
	})
	public ResponseEntity<?> preferences(
			@RequestParam String userId,
			@RequestParam Boolean allowContactByPhone,
			@RequestParam Boolean allowContactByMail
	) {
		return ResponseEntity.status(HttpStatus.OK).body(notificationsService.preferences(userId, allowContactByPhone, allowContactByMail));
	}
}
