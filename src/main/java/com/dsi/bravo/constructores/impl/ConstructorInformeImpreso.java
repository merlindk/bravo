package com.dsi.bravo.constructores.impl;


import com.dsi.bravo.constructores.IConstructorInformeGuardias;
import com.dsi.bravo.informes.InformeImpreso;
import com.dsi.bravo.soporte.Resultado;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * This class (a) constructs and assembles parts of the product by implementing
 * the Builder interface, (b) defines and keeps track of the representation it
 * creates, and (c) provides an interface for retrieving the product.
 *
 * @author matia
 * @version 1.0
 * @created 04-Nov-2019 10:30:17 PM
 */
public class ConstructorInformeImpreso implements IConstructorInformeGuardias {

    public void construirCuerpo(List<Resultado> resultados) {

    }

    /**
     * @param fechaInicio
     * @param fechaFin
     */
    public void construirEncabezado(LocalDate fechaInicio, LocalDate fechaFin) {

    }

    public void construirInforme() {

    }

    /**
     * @param usuario
     * @param fechaHora
     */
    public void construirPie(String usuario, LocalDateTime fechaHora) {

    }

    public InformeImpreso obtenerResultado() {
        //return product;

        return null;
    }
}//end ConstructorInformeImpreso