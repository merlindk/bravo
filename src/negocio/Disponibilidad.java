package negocio;

import java.util.Date;

/**
 * @author Merlin
 * @version 1.0
 * @created 04-Nov-2019 10:20:45 PM
 */
public class Disponibilidad {

	private Date fechaFinVigencia;
	private Date fechaInicioVigencia;
	public DetalleDisponibilidad m_DetalleDisponibilidad;

	public Disponibilidad(){

	}

	public void finalize() throws Throwable {

	}
	public void esHorarioValido(){

	}

	public boolean esVigente(){
		return false;
	}

	public String mostrarDisponibilidadCompleta(){
		return null;
	}
}//end Disponibilidad