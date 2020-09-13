package br.com.soccerbetsurvivor.db.container;

import org.junit.ClassRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class AbstractTestContainer {

    @ClassRule
    public static MySQLContainer<?> mysqlContainer = MySQLDBContainer.getInstance();
}
