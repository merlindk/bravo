package com.dsi.bravo.negocio;

/**
 * @author Merlin
 * @version 1.0
 * @created 04-Nov-2019 10:20:46 PM
 */
public class Estado {

    private String ambito;
    private String descripcion;
    private String nombre;

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    public void esAmbitoGuardia() {

    }

    public void esAmbitoProgramacion() {

    }

    public void esAmbitoProgramacionGuardia() {

    }

    public boolean esEnCurso() {
        return nombre.equals("EnCurso"); //TODO horrible
    }

    public void esPendienteDeConfirmacion() {

    }

    public void esProgramada() {

    }

    public String getNombre() {
        return nombre;
    }
}//end Estado