package br.com.soccerbetsurvivor.service.impl;

import org.springframework.stereotype.Service;

import br.com.soccerbetsurvivor.model.User;
import br.com.soccerbetsurvivor.repository.UserRepository;
import br.com.soccerbetsurvivor.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User save(User user) {
		return this.userRepository.save(user);
	}
	
}
