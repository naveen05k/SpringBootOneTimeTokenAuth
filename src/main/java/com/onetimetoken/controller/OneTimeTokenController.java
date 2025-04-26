/**
 * 
 */
package com.onetimetoken.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onetimetoken.service.OneTimeTokenService;

/**
 * @author HP Apr 26, 2025SpringBootOneTimeTokenAuth
 */
@Controller
@RequestMapping("/api/token")
public record OneTimeTokenController(OneTimeTokenService tokenService) {

	@PostMapping("/generate")
	public ResponseEntity<String> generate(@RequestParam String email) {
		tokenService.generateAndSendToken(email);
		return ResponseEntity.ok("Token sent to your email.");
	}

	@GetMapping("/secure")
	public String accessSecure(@RequestParam String token) {
		if (tokenService.validateToken(token)) {
			// Redirect to dashboard after successful validation
			return "redirect:/api/token/dashboard";

		} else {
			return "error"; // stay here if token invalid/expired
		}
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard"; // loads dashboard.html
	}

}
