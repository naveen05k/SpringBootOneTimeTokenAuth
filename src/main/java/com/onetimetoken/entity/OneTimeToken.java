package com.onetimetoken.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Naveenkuamr D Apr 26, 2025
 */
@Entity
@Table(name = "onetimetoken")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class OneTimeToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String token;

	private String email;

	private LocalDateTime expiryDate;

	private boolean used;
}