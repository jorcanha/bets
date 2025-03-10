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
@Table(name = "bets")
public class Bets {

	@Id
	@GeneratedValue(strategy= GenerationType.UUID)
	private String id;
	private Boolean betWon;
	private String betScore;
	private LocalDateTime betDate;

	@ManyToOne
	private Events events;

	@ManyToOne
	private Users users;
}
