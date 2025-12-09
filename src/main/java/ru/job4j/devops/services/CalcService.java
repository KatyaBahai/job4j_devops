package ru.job4j.devops.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.devops.models.CalcEvent;
import ru.job4j.devops.models.Result;
import ru.job4j.devops.models.User;
import ru.job4j.devops.repositories.CalcEventRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CalcService {
    private CalcEventRepository calcEventRepository;

    public CalcEvent addTwoNumbers(User user, Double first, Double second) {
        Double result = first + second;
        Instant creationData = Instant.now().truncatedTo(ChronoUnit.MINUTES);
        CalcEvent calcEvent = CalcEvent.builder()
                .type("addition")
                .user(user)
                .creationDate(creationData)
                .first(first)
                .second(second)
                .result(result)
                .build();
        return calcEventRepository.save(calcEvent);
    }

    public Optional<CalcEvent> findById(Long id) {
        return calcEventRepository.findById(id);
    }
}
