package com.global.bets.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy= GenerationType.UUID)
	private String id;

	private String firstName;
	private String lastName;

	private String phone;
	private String mail;

	private Boolean allowContactByPhone;
	private Boolean allowContactByMail;
}
