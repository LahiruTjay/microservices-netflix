package com.tjay.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/user")
	public String getName() {
		return "USER-SERVICE";
	}
	
	@GetMapping("/user_movie")
	public String getRegUser() {
		return "USER-FROM-MOVIIE";
	}

}
