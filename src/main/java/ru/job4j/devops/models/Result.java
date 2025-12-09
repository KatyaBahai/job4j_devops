package ru.job4j.devops.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * Represents the result of a calculator operation.
 * Holds a single numeric value returned by the API.
 */
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "first_arg")
    private Double firstArg;

    @Column(name = "second_arg")
    private Double secondArg;

    /**
     * The numeric value produced by a calculation.
     */
    private Double result;

    @Column(name = "creation_date")
    private Instant createDate;

    private String operation;

    /**
     * Creates an empty Result object.
     * The value will need to be set later, for example through JSON deserialization.
     */
    public Result() {
    }
}
