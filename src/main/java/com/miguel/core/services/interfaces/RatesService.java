package com.miguel.core.services.interfaces;

import com.miguel.core.exceptions.specific_exception.BadRequestException;
import com.miguel.core.exceptions.specific_exception.NoContentRequestException;
import com.miguel.model.RatesDto;
import com.miguel.model.out.RatesOutDto;
import org.springframework.data.domain.*;


public interface RatesService {
    /**
     * Servicio para gestionar las tarifas (rates) en el sistema.
     */

        /**
         * Agrega una nueva tarifa al sistema.
         * @param rate El DTO de la tarifa a agregar.
         * @return El ID de la tarifa agregada.
         * @throws BadRequestException Si los datos son inválidos.
         */
        long addRate(RatesDto rate) throws BadRequestException;

        /**
         * Elimina una tarifa existente.
         * @param idRate El ID de la tarifa a eliminar.
         * @return Mensaje de confirmación de la eliminación.
         * @throws NoContentRequestException Si la tarifa no existe.
         */
        String deleteRate(long idRate) throws NoContentRequestException;

        /**
         * Obtiene una tarifa por su ID.
         *
         * @param idRate El ID de la tarifa.
         * @return El DTO de la tarifa encontrada.
         * @throws NoContentRequestException Si no se encuentra la tarifa.
         * @throws BadRequestException       Si el ID proporcionado es inválido.
         */
        RatesOutDto getRateById(long idRate) throws NoContentRequestException, BadRequestException;

        /**
         * Obtiene una lista paginada de tarifas filtradas por una consulta.
         *
         * @param q        Filtro de búsqueda (consulta).
         * @param pageable Información de paginación.
         * @return Página de tarifas.
         */
        Slice<RatesOutDto> getAll(String q, Pageable pageable);

        /**
         * Actualiza una tarifa existente.
         *
         * @param rate El DTO de la tarifa a actualizar.
         * @return El DTO de la tarifa actualizada.
         * @throws NoContentRequestException Si la tarifa no existe.
         * @throws BadRequestException       Si los datos proporcionados son inválidos.
         */
        RatesOutDto updateRate(RatesDto rate) throws NoContentRequestException, BadRequestException;

}
