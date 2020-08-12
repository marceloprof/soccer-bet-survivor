package br.com.soccerbetsurvivor.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.soccerbetsurvivor.dto.UserDTO;
import br.com.soccerbetsurvivor.model.User;
import br.com.soccerbetsurvivor.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}		
	
	@PostMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User save(@RequestBody UserDTO user) {
		return this.userService.save(User.builder().login(user.getLogin()).password(user.getPassword()).build());
	}

}
