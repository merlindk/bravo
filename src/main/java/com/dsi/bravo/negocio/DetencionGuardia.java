package com.dsi.bravo.negocio;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Merlin
 * @version 1.0
 * @created 04-Nov-2019 10:20:43 PM
 */
public class DetencionGuardia {

	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaDesde;
	private LocalDateTime fechaHasta;
	private String motivo;

	public DetencionGuardia(){

	}

	public void finalize() throws Throwable {

	}
	public int calcularDuracion(){
		return 0;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(LocalDateTime fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public LocalDateTime getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(LocalDateTime fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}//end DetencionGuardia