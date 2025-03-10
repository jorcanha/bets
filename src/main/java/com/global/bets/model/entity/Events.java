package com.global.bets.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Events {

	@Id
	@GeneratedValue(strategy= GenerationType.UUID)
	private String id;
	private String score;
	private String eventName;
	private Boolean isEventActive;
	private LocalDateTime eventDate;
}
