package com.miguel.api.controller.implementations.rates;

import com.miguel.api.controller.interfaces.rates.RateController;
import com.miguel.core.exceptions.specific_exception.BadRequestException;
import com.miguel.core.exceptions.specific_exception.NoContentRequestException;
import com.miguel.core.services.interfaces.RatesService;
import com.miguel.model.RatesDto;
import com.miguel.model.out.RatesOutDto;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RestController
public class RatControllerImpl implements RateController {

    RatesService ratesService;

    @Override
    public Slice<RatesOutDto> getRatesAll(String query, Pageable pageable) {
        // Llama al servicio para obtener todas las tarifas filtradas
        return ratesService.getAll(query, pageable);
    }

    @Override
    public long addRate(RatesDto ratesDto) throws BadRequestException {
        // Valida y agrega una nueva tarifa
        return ratesService.addRate(ratesDto);
    }

    @Override
    public RatesOutDto getRateById(long idRate) throws NoContentRequestException, BadRequestException {
        // Obtiene una tarifa por ID o lanza una excepción
        return ratesService.getRateById(idRate);
    }

    @Override
    public String deleteRate(long idRate) throws NoContentRequestException {
        // Elimina una tarifa por ID y devuelve una confirmación
        return ratesService.deleteRate(idRate);
    }

    @Override
    public RatesOutDto updateRate(RatesDto ratesDto) throws NoContentRequestException, BadRequestException {
        // Actualiza los datos de una tarifa existente
        return ratesService.updateRate(ratesDto);
    }
}