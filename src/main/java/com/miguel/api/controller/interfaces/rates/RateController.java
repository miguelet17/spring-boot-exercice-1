package com.miguel.api.controller.interfaces.rates;

import com.miguel.core.exceptions.specific_exception.BadRequestException;
import com.miguel.core.exceptions.specific_exception.NoContentRequestException;
import com.miguel.model.RatesDto;
import com.miguel.model.out.RatesOutDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid; // Usando Jakarta Validation

@Tag(name = "rates", description = "Available operations for the rates domain.")
@RestController
@RequestMapping("/rates/v1")
public interface RateController {

    @Operation(summary = "Get rate list", operationId = "getRates")
    @GetMapping
    Slice<RatesOutDto> getRatesAll(
            @RequestParam(name = "q", required = false, defaultValue = "") String query,
            Pageable pageable
    );

    @Operation(summary = "Add a new rate", operationId = "addRate")
    @PostMapping
    long addRate(@Valid @RequestBody RatesDto ratesDto) throws BadRequestException;

    @Operation(summary = "Get rate by ID", operationId = "getRateById")
    @GetMapping("/{idRate}")
    RatesOutDto getRateById(@PathVariable(name = "idRate") long idRate) throws NoContentRequestException, BadRequestException;

    @Operation(summary = "Delete rate by ID", operationId = "deleteRate")
    @DeleteMapping("/{idRate}")
    String deleteRate(@PathVariable(name = "idRate") long idRate) throws NoContentRequestException;

    @Operation(summary = "Update an existing rate", operationId = "updateRate")
    @PutMapping
    RatesOutDto updateRate(@Valid @RequestBody RatesDto ratesDto) throws NoContentRequestException, BadRequestException;
}