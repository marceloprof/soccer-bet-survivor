package br.com.soccerbetsurvivor.service.impl;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.soccerbetsurvivor.model.User;
import br.com.soccerbetsurvivor.repository.UserRepository;
import br.com.soccerbetsurvivor.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
	@Mock
	private UserRepository userRepository;
	
	@Test
	public void saveTest() {
		User user = User.builder().id(1L).login("login").password("password").build();
		when(userRepository.save(any(User.class))).thenReturn(user);
		
		UserServiceImpl userServiceImpl = new UserServiceImpl(userRepository);
		User userResult = userServiceImpl.save(user);
		
		assertThat(userResult).isNotNull();
	}

}
