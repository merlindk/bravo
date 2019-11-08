package com.dsi.bravo.negocio;

import java.time.LocalDateTime;
import java.util.Date;

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

	public Convocatoria(){

	}

	public void finalize() throws Throwable {

	}
	public void confirmarAsistencia(){

	}

	public boolean estaConfirmada(){
		return confirmo;
	}

	public void estaEnFecha(){

	}

	public void estaEnPeriodo(){

	}

	public Bombero getBombero(){
		return bombero;
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

	public void setBombero(Bombero bombero) {
		this.bombero = bombero;
	}
}//end Convocatoria