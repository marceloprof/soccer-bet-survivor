package br.com.soccerbetsurvivor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.junit.jupiter.Testcontainers;

import br.com.soccerbetsurvivor.db.container.AbstractTestContainer;
import br.com.soccerbetsurvivor.model.User;

@Testcontainers
public class UserRespositoryTest extends AbstractTestContainer {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldTestInsertUser() {
        User user = User.builder().id(1L).login("login").password("password")
                .name("Test").email("email@teste.com.br").build();
        user = userRepository.save(user);

       assertEquals(1l, user.getId());
    }

}
