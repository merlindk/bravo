package negocio;

import java.util.Date;

/**
 * @author Merlin
 * @version 1.0
 * @created 04-Nov-2019 10:20:41 PM
 */
public class Convocatoria {

	private boolean confirmo;
	private Date fechaHora;
	private Date fechaHoraRespuesta;
	public Bombero bombero;

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

	public Date getFechaHora(){
		return fechaHora;
	}
}//end Convocatoria