package ru.job4j.devops.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the result of a calculator operation.
 * Holds a single numeric value returned by the API.
 */
@Data
@AllArgsConstructor
public class Result {
    /**
     * The numeric value produced by a calculation.
     */
    private double value;

    /**
     * Creates an empty Result object.
     * The value will need to be set later, for example through JSON deserialization.
     */
    public Result() {
    }
}
