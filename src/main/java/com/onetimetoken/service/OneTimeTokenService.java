/**
 * 
 */
package com.onetimetoken.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.onetimetoken.entity.OneTimeToken;
import com.onetimetoken.repository.OneTimeTokenRepository;

/**
 * @author HP Apr 26, 2025SpringBootOneTimeTokenAuth
 */
@Service
public record OneTimeTokenService(OneTimeTokenRepository tokenRepository, EmailService emailService) {

	public String generateAndSendToken(String email) {
		String token = UUID.randomUUID().toString();
		OneTimeToken entity = new OneTimeToken();

		entity.setToken(token);
		entity.setEmail(email);
		entity.setExpiryDate(LocalDateTime.now().plusMinutes(15));
		entity.setUsed(false);
		tokenRepository.save(entity);
		System.out.println("Token " + token);
		emailService.sendToken(email, token);
		return token;
	}

	public boolean validateToken(String token) {
		Optional<OneTimeToken> optionalToken = tokenRepository.findByToken(token);
		if (optionalToken.isEmpty())
			return false;

		OneTimeToken ott = optionalToken.get();
		if (ott.isUsed() || ott.getExpiryDate().isBefore(LocalDateTime.now()))
			return false;

		ott.setUsed(true); // mark as used
		tokenRepository.save(ott);
		return true;
	}
}
