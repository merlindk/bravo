package com.dsi.bravo.negocio;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Merlin
 * @version 1.0
 * @created 04-Nov-2019 10:20:43 PM
 */
public class DetalleGuardiaBombero {

	private LocalDateTime horaDesde;
	private LocalDateTime horaHasta;

	public DetalleGuardiaBombero(){

	}

	public void finalize() throws Throwable {

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

	public String mostrarDatos(){
		return null;
	}

}//end DetalleGuardiaBombero