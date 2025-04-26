/**
 * 
 */
package com.onetimetoken.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author HP Apr 26, 2025SpringBootOneTimeTokenAuth
 */
@Service
public record EmailService(JavaMailSender javaMailSender) {
	private static final String BASE_URL = "http://localhost:8080/api/token/secure?token=";

	public void sendToken(String toEmail, String token) {
		String accessLink = BASE_URL + token;

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("Your One-Time Access Link");
		message.setText("Click the link to access the secure resource:\n\n" + accessLink);
		javaMailSender.send(message);
	}
}
