package ru.job4j.devops.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import jakarta.transaction.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.job4j.devops.models.CalcEvent;
import ru.job4j.devops.models.User;
import ru.job4j.devops.repositories.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CalcServiceTest {
    private static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:16-alpine"
    ).withReuse(true);

    @Autowired
    private CalcService calcService;
    @Autowired
    private UserRepository userRepository;

    @DynamicPropertySource
    public static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @Test
    @Transactional
    public void whenAddTwoNumbers() {
        User user = User.builder()
                .username("Anton")
                .build();
        userRepository.save(user);

        Double first = 3d;
        Double second = 4d;
        Double result = first + second;

        CalcEvent addedEvent = calcService.addTwoNumbers(user, first, second);

        var retrievedCalcEvent = calcService.findById(addedEvent.getId());
        assertThat(retrievedCalcEvent).isPresent();
        assertThat(retrievedCalcEvent.get().getFirst()).isEqualTo(first);
        assertThat(retrievedCalcEvent.get().getSecond()).isEqualTo(second);
        assertThat(retrievedCalcEvent.get().getResult()).isEqualTo(result);
        assertThat(retrievedCalcEvent.get().getUser().getUsername()).isEqualTo(user.getUsername());
        assertThat(retrievedCalcEvent.get().getCreationDate()).isNotNull();
    }
}
