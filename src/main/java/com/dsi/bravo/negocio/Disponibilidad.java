package com.dsi.bravo.negocio;

import java.time.LocalDateTime;

public class Disponibilidad {

    private String fechaFinVigencia;
    private String fechaInicioVigencia;
    private DetalleDisponibilidad detalleDisponibilidad;

    public Disponibilidad() {

    }

    public Disponibilidad(String fechaFinVigencia, String fechaInicioVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public String getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(String fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public String getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(String fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public DetalleDisponibilidad getDetalleDisponibilidad() {
        return detalleDisponibilidad;
    }

    public void setDetalleDisponibilidad(DetalleDisponibilidad detalleDisponibilidad) {
        this.detalleDisponibilidad = detalleDisponibilidad;
    }

    public void finalize() throws Throwable {

    }

    public void esHorarioValido() {

    }

    public boolean esVigente() {
        return false;
    }

    public String mostrarDisponibilidadCompleta() {
        return null;
    }
}//end Disponibilidad