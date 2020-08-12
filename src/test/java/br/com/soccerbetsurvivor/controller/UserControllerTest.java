package br.com.soccerbetsurvivor.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.soccerbetsurvivor.model.User;
import br.com.soccerbetsurvivor.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void saveUserTest() throws Exception {
		when(userService.save(any(User.class))).thenReturn(User.builder().id(1L).login("login").password("password").build());
		
		MvcResult result = this.mockMvc.perform(post("/user").content(objectMapper.writeValueAsString(User.builder().build())).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		
		User userResult = objectMapper.readValue(result.getResponse().getContentAsString(), User.class);
		
		assertThat(userResult.getId()).isNotNull();
	}
	
}
