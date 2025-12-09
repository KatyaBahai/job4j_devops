package ru.job4j.devops.services.result;

import ru.job4j.devops.models.Result;
import java.util.List;

public interface ResultService {
    void save(Result result);

    List<Result> findAll();
}
