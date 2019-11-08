package com.dsi.bravo.constructores;


import java.util.Date;

/**
 * This class specifies an abstract interface for creating parts of a Product
 * object.
 * @author matia
 * @version 1.0
 * @created 04-Nov-2019 10:30:16 PM
 */
public interface IConstructorInformeGuardias {


	void finalize() throws Throwable ;

	void agregarBombero();

	/**
	 * 
	 * @param cumpimientoGuardia
	 */
	void construirCuerpo(String[][] cumpimientoGuardia);

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 */
	void construirEncabezado(Date fechaInicio, Date fechaFin);

	void construirInforme();

	/**
	 * 
	 * @param usuario
	 * @param fechaHora
	 */
	 void construirPie(String usuario, Date fechaHora);
}//end IConstructorInformeGuardias