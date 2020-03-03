package com.tjay.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserAPI {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getUser")
	@HystrixCommand(fallbackMethod = "getUserFallback")
	public String getUser() {
		String url = "http://user-service/user";
		return restTemplate.getForObject(url, String.class);
	}

	public String getUserFallback() {
		return "User-Service fallback";
	}
	
	@GetMapping("/getMovie")
	@HystrixCommand(fallbackMethod = "getMovieFallback")
	public String getMovie( ) {
		String url = "http://movie-service/movie";
		return restTemplate.getForObject(url, String.class);
	}
	
	public String getMovieFallback() {
		return "Movie-Service fallback";
	}
	
	@GetMapping("/getMovieP")
	public String getMovieForUser( ) {
		String url = "http://movie-service/movie_user";
		return restTemplate.getForObject(url, String.class);
	}
	
}
