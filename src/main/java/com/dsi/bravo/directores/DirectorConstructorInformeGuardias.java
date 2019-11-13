package com.dsi.bravo.directores;


import com.dsi.bravo.constructores.IConstructorInformeGuardias;
import com.dsi.bravo.soporte.Resultado;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * This class constructs an object using the Builder interface.
 *
 * @author matia
 * @version 1.0
 * @created 04-Nov-2019 10:30:14 PM
 */
public class DirectorConstructorInformeGuardias {

    private IConstructorInformeGuardias contructor;

    public DirectorConstructorInformeGuardias(IConstructorInformeGuardias contructor) {
        this.contructor = contructor;
    }


    public void construir(LocalDate fechaInicio, LocalDate fechaFin, List<Resultado> resultados, String usuario, LocalDateTime fechaHora) {
        contructor.construirInforme();
        contructor.construirEncabezado(fechaInicio, fechaFin);
        contructor.construirCuerpo(resultados);
        contructor.construirPie(usuario, fechaHora);
    }


}