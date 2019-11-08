package com.dsi.bravo.negocio;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Merlin
 * @version 1.0
 * @created 04-Nov-2019 10:20:36 PM
 */
public class Asistencia {

	private LocalDateTime fechaHoraLlegada;
	private LocalDateTime fechaHoraSalida;
	private GuardiaBombero guardiaBombero;

	public Asistencia(){

	}

	public Asistencia(LocalDateTime fechaHoraLlegada, LocalDateTime fechaHoraSalida) {
		this.fechaHoraLlegada = fechaHoraLlegada;
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public void finalize() throws Throwable {

	}
	public void esDeFechaYGuardiaEnCurso(){

	}

	public void estaEnCurso(){

	}

	public void obtenerAsistenciaAbierta(){

	}

	public LocalDateTime getFechaHoraLlegada() {
		return fechaHoraLlegada;
	}

	public void setFechaHoraLlegada(LocalDateTime fechaHoraLlegada) {
		this.fechaHoraLlegada = fechaHoraLlegada;
	}

	public LocalDateTime getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}
}//end AsistenciaEntity