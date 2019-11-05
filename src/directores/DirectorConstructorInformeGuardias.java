package directores;


import constructores.IConstructorInformeGuardias;

import java.util.Date;

/**
 * This class constructs an object using the Builder interface.
 * @author matia
 * @version 1.0
 * @created 04-Nov-2019 10:30:14 PM
 */
public class DirectorConstructorInformeGuardias {

	private IConstructorInformeGuardias contructor;

	public DirectorConstructorInformeGuardias(IConstructorInformeGuardias contructor) {
		this.contructor = contructor;
	}

	public DirectorConstructorInformeGuardias(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @param guardiasPorBombero
	 * @param usuario
	 * @param fechaHora
	 */
	public void construir(Date fechaInicio, Date fechaFin, String[][] guardiasPorBombero, String usuario, Date fechaHora){

	}


}//end DirectorConstructorInformeGuardias