package ru.job4j.devops.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.devops.controllers.api.CalcControllerApi;
import ru.job4j.devops.models.Result;
import ru.job4j.devops.models.TwoArgs;

/**
 * REST controller that exposes basic calculator operations.
 * Handles HTTP requests for addition and multiplication of two numbers.
 */
@RestController
@RequestMapping("calc")
public class CalcController implements CalcControllerApi {

    /**
     * Creates an empty CalcController object.
     */
    public CalcController() {
    }

    /**
     * Adds two numbers provided in the request body.
     *
     * @param twoArgs the two numeric arguments to sum
     * @return a response containing the result of the addition
     */
    @PostMapping("summarise")
    public ResponseEntity<Result> summarise(@RequestBody TwoArgs twoArgs) {
        var result = twoArgs.getFirst() + twoArgs.getSecond();
        return ResponseEntity.ok(new Result(result));
    }

    /**
     * Multiplies two numbers provided in the request body.
     *
     * @param twoArgs the two numeric arguments to multiply
     * @return a response containing the result of the multiplication
     */
    @PostMapping("times")
    public ResponseEntity<Result> times(@RequestBody TwoArgs twoArgs) {
        var result = twoArgs.getFirst() * twoArgs.getSecond();
        return ResponseEntity.ok(new Result(result));
    }
}
