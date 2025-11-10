package ru.job4j.devops.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import ru.job4j.devops.models.Result;
import ru.job4j.devops.models.TwoArgs;

/**
 * API for calculator operations.
 */
@Tag(name = "AuthController", description = "AuthController management APIs")
public interface CalcControllerApi {
    /**
     * Adds two numbers.
     *
     * @param twoArgs the two numbers to sum
     * @return the calculation result
     */
    @Operation(
            summary = "Add 2 numbers",
            tags = {"post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = Result.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())})})
    ResponseEntity<Result> summarise(@RequestBody TwoArgs twoArgs);

    /**
     * Multiplies two numbers.
     *
     * @param twoArgs the two numbers to multiply
     * @return the calculation result
     */
    @Operation(
            summary = "Multiply two numbers",
            tags = {"post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = Result.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())})})
    ResponseEntity<Result> times(@RequestBody TwoArgs twoArgs);

}
