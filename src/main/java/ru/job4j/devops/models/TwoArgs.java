package ru.job4j.devops.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A class that contains 2 numbers meant for math operations
 */
@Data
@AllArgsConstructor
public class TwoArgs {
    private double first;
    private double second;

    /**
     * Creates an empty TwoArgs object.
     * Values must be set later via JSON input.
     */
    public TwoArgs() {
    }
}
