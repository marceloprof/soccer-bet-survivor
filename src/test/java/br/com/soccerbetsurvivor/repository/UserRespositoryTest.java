package br.com.soccerbetsurvivor.repository;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.soccerbetsurvivor.db.container.AbstractTestContainer;
import br.com.soccerbetsurvivor.model.User;

@RunWith(SpringRunner.class)
public class UserRespositoryTest extends AbstractTestContainer {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldTestInsertUser() {
        User user = User.builder().id(1L).login("login").password("password")
                .name("Test").email("email@teste.com.br").build();
        user = userRepository.save(user);

        assertTrue(user.getId() != null);
    }

}
