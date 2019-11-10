package com.dsi.bravo.constructores.impl;


import com.dsi.bravo.constructores.IConstructorInformeGuardias;
import com.dsi.bravo.informes.InformeArchivoExcel;

import java.util.Date;

/**
 * This class (a) constructs and assembles parts of the product by implementing
 * the Builder interface, (b) defines and keeps track of the representation it
 * creates, and (c) provides an interface for retrieving the product.
 *
 * @author matia
 * @version 1.0
 * @created 04-Nov-2019 10:30:18 PM
 */
public class ConstructorInformeExcel implements IConstructorInformeGuardias {

    public ConstructorInformeExcel() {

    }

    public void agregarBombero() {

    }

    /**
     * @param cumpimientoGuardia
     */
    public void construirCuerpo(String[][] cumpimientoGuardia) {

    }

    /**
     * @param fechaInicio
     * @param fechaFin
     */
    public void construirEncabezado(Date fechaInicio, Date fechaFin) {

    }

    public void construirInforme() {

    }

    /**
     * @param usuario
     * @param fechaHora
     */
    public void construirPie(String usuario, Date fechaHora) {

    }

    public InformeArchivoExcel obtenerResultado() {
        //return product;

        return null;
    }
}//end ConstructorInformeExcel