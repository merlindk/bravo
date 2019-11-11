package com.dsi.bravo.negocio;

import java.time.LocalDateTime;

/**
 * @author Merlin
 * @version 1.0
 * @created 04-Nov-2019 10:20:41 PM
 */
public class Convocatoria {

    private boolean confirmo;
    private LocalDateTime fechaHora;
    private LocalDateTime fechaHoraRespuesta;
    private Bombero bombero;

    public Convocatoria(boolean confirmo, LocalDateTime fechaHora, LocalDateTime fechaHoraRespuesta, Bombero bombero) {
        this.confirmo = confirmo;
        this.fechaHora = fechaHora;
        this.fechaHoraRespuesta = fechaHoraRespuesta;
        this.bombero = bombero;
    }

    public void confirmarAsistencia() {

    }

    public boolean estaConfirmada() {
        return confirmo;
    }

    public void estaEnFecha() {

    }

    public boolean estaEnPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return fechaInicio.isBefore(fechaHora) && fechaFin.isAfter(fechaHora);
    }

    public Bombero getBombero() {
        return bombero;
    }

    public void setBombero(Bombero bombero) {
        this.bombero = bombero;
    }

    public boolean isConfirmo() {
        return confirmo;
    }

    public void setConfirmo(boolean confirmo) {
        this.confirmo = confirmo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public LocalDateTime getFechaHoraRespuesta() {
        return fechaHoraRespuesta;
    }

    public void setFechaHoraRespuesta(LocalDateTime fechaHoraRespuesta) {
        this.fechaHoraRespuesta = fechaHoraRespuesta;
    }
}//end Convocatoria