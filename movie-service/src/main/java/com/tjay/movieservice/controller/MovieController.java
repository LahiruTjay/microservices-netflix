package com.tjay.movieservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/movie")
	public String getMovie() {
		return "MOVIE-SERVICE";
	}

	@GetMapping("/movie_user")
	@HystrixCommand(fallbackMethod = "getFromUserFallbacks")
	public String gerFromUser() {
		String url = "http://user-service/user_movie";
		return restTemplate.getForObject(url, String.class);
	}
	
	public String getFromUserFallbacks() {
		return "MO-USER-FROM-MOVIIE";
	}

}
