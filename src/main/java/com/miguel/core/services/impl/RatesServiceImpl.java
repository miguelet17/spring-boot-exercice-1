package com.miguel.core.services.impl;

import com.miguel.core.exceptions.specific_exception.BadRequestException;
import com.miguel.core.exceptions.specific_exception.NoContentRequestException;
import com.miguel.core.mapper.RateMapper;
import com.miguel.core.services.interfaces.RatesService;
import com.miguel.model.RatesDto;
import com.miguel.model.out.RatesOutDto;
import com.miguel.persistence.entity.Rates;
import com.miguel.persistence.repository.RatesRepository;
import com.turkraft.springfilter.converter.FilterSpecificationConverter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Service
public class RatesServiceImpl implements RatesService {

    RatesRepository ratesRepository;
    RateMapper rateMapper;
    FilterSpecificationConverter filterSpecificationConverter;

    // Constantes para mensajes de error
    private static final String EMPTY_ID_ERROR = "El ID de la tarifa no puede estar vacío.";
    private static final String NOT_FOUND_ERROR = "No se encontró la tarifa con el ID especificado.";
    private static final String INVALID_RATE_ERROR = "La tarifa no tiene los campos requeridos: moneda, marca o producto.";

    /**
     * Valida y obtiene una tarifa por su ID.
     */
    private Rates getRateOrThrow(Long idRate) throws NoContentRequestException, BadRequestException {
        if (idRate == null) {
            throw new BadRequestException(EMPTY_ID_ERROR);
        }
        return ratesRepository.findById(idRate)
                .orElseThrow(() -> new NoContentRequestException(NOT_FOUND_ERROR));
    }

    /**
     * Valida si los campos esenciales de la tarifa son correctos.
     */
    private void validateRateFields(Rates rate) throws BadRequestException {
        boolean isValid = rate.getCurrency() != null || rate.getBrand() != null || rate.getProduct() != null;
        if (!isValid) {
            throw new BadRequestException(INVALID_RATE_ERROR);
        }
    }

    @Override
    public long addRate(RatesDto rateAdd) throws BadRequestException {
        rateAdd.setId(null); // Aseguramos que sea una nueva tarifa
        val rate = rateMapper.rateFromRateDto(rateAdd);
        validateRateFields(rate);
        return ratesRepository.saveAndFlush(rate).getId();
    }

    @Override
    public String deleteRate(long idRate) throws NoContentRequestException {
        if (!ratesRepository.existsById(idRate)) {
            throw new NoContentRequestException(NOT_FOUND_ERROR);
        }
        ratesRepository.deleteById(idRate);
        return "La tarifa se ha borrado correctamente.";
    }

    @Override
    public RatesOutDto getRateById(long idRate) throws NoContentRequestException, BadRequestException {
        val rate = getRateOrThrow(idRate);
        return rateMapper.rateDtoFromRate(rate);
    }

    @Override
    public RatesOutDto updateRate(RatesDto rateUpdate) throws NoContentRequestException, BadRequestException {
        getRateOrThrow(rateUpdate.getId()); // Aseguramos que existe antes de actualizar
        val rate = rateMapper.rateFromRateDto(rateUpdate);
        validateRateFields(rate);
        val updatedRate = ratesRepository.saveAndFlush(rate);
        return rateMapper.rateDtoFromRate(updatedRate);
    }

    @Override
    public Slice<RatesOutDto> getAll(String query, Pageable pageable) {
        // Convertimos la query en una especificación solo si no está vacía
        return ratesRepository
                .findAll(query.isBlank() ? null : filterSpecificationConverter.convert(query), pageable)
                .map(rateMapper::rateDtoFromRate);
    }
}