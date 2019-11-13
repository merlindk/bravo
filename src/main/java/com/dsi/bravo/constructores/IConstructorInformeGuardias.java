package com.dsi.bravo.constructores;


import com.dsi.bravo.soporte.Resultado;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * This class specifies an abstract interface for creating parts of a Product
 * object.
 *
 * @author matia
 * @version 1.0
 * @created 04-Nov-2019 10:30:16 PM
 */
public interface IConstructorInformeGuardias {

    void construirCuerpo(List<Resultado> resultados);

    /**
     * @param fechaInicio
     * @param fechaFin
     */
    void construirEncabezado(LocalDate fechaInicio, LocalDate fechaFin);

    void construirInforme();

    /**
     * @param usuario
     * @param fechaHora
     */
    void construirPie(String usuario, LocalDateTime fechaHora);
}//end IConstructorInformeGuardias