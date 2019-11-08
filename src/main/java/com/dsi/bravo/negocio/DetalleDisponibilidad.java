package com.dsi.bravo.negocio;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Merlin
 * @version 1.0
 * @created 04-Nov-2019 10:20:42 PM
 */
public class DetalleDisponibilidad {

	private LocalDateTime horaDesde;
	private LocalDateTime horaHasta;
	private String diaSemana;

	public DetalleDisponibilidad(){

	}

	public void finalize() throws Throwable {

	}
	public void esRangoValido(){

	}

	public LocalDateTime getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(LocalDateTime horaDesde) {
		this.horaDesde = horaDesde;
	}

	public LocalDateTime getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(LocalDateTime horaHasta) {
		this.horaHasta = horaHasta;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String mostrarDatos(){
		return null;
	}
}//end DetalleDisponibilidad