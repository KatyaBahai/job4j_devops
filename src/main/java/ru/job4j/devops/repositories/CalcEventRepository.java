package ru.job4j.devops.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.devops.models.CalcEvent;

public interface CalcEventRepository  extends JpaRepository<CalcEvent, Long> {
}
