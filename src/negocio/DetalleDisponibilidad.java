package negocio;

import java.util.Date;

/**
 * @author Merlin
 * @version 1.0
 * @created 04-Nov-2019 10:20:42 PM
 */
public class DetalleDisponibilidad {

	private Date horaDesde;
	private Date horaHasta;
	public String diaSemana;

	public DetalleDisponibilidad(){

	}

	public void finalize() throws Throwable {

	}
	public void esRangoValido(){

	}

	public Date getHoraDesde(){
		return horaDesde;
	}

	public Date getHoraHasta(){
		return horaHasta;
	}

	public String mostrarDatos(){
		return null;
	}
}//end DetalleDisponibilidad