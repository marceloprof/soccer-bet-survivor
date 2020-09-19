package br.com.soccerbetsurvivor.db.container;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(initializers = AbstractTestContainer.Initializer.class)
@ActiveProfiles("test")
@Slf4j
public abstract class AbstractTestContainer {


	@Container
	protected static final MySQLContainer MY_SQL_CONTAINER =
	      new MySQLContainer<>("mysql:5.7")
	          .withDatabaseName("survivor")
	          .withUsername("test")
	          .withPassword("test")
	          .withExposedPorts(3306);
	
	public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

		public void initialize(ConfigurableApplicationContext applicationContext) {
			MY_SQL_CONTAINER.start();

			String jdbcUrl = MY_SQL_CONTAINER.getJdbcUrl();

			log.info("[TEST] " + jdbcUrl);

			TestPropertyValues.of(
			          "spring.datasource.url=" + MY_SQL_CONTAINER.getJdbcUrl(),
			          "spring.datasource.username=" + MY_SQL_CONTAINER.getUsername(),
			          "spring.datasource.password=" + MY_SQL_CONTAINER.getPassword()
			          )
			          .applyTo(applicationContext);
		}


		
	}

}
