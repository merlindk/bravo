package com.dsi.bravo.informes;


import java.util.Date;

/**
 * This class (a) represents the complex object under construction.
 * ConcreteBuilder builds the product's internal representation and defines the
 * process by which it's assembled, and (b) includes classes that define the
 * constituent parts, including interfaces for assembling the parts into the final
 * result.
 * @author matia
 * @version 1.0
 * @created 04-Nov-2019 10:30:21 PM
 */
public class InformeArchivoExcel {

	private String[] bomberos;
	private int fechaHoraPie;
	private String[] porcentajeBomberos;
	private String titulo;
	private String usuarioPie;

	public InformeArchivoExcel(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param bombero
	 */
	public void addBombero(String bombero){

	}

	/**
	 * 
	 * @param porcentaje
	 */
	public void addPorcentajeGuardia(String porcentaje){

	}

	/**
	 * 
	 * @param bombero
	 * @param porcentajeGuardias
	 */
	public void agregarCuerpo(String bombero, String porcentajeGuardias){

	}

	/**
	 * 
	 * @param titulo
	 */
	public void agregarEncabezado(String titulo){

	}

	/**
	 * 
	 * @param usuario
	 * @param fechaHora
	 */
	public void agregarPie(String usuario, Date fechaHora){

	}


	public String obtenerDatos(){
		return "";
	}

	/**
	 * 
	 * @param fechaHora
	 */
	public void setFechaHoraPie(Date fechaHora){

	}

	/**
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo){

	}

	/**
	 * 
	 * @param usuario
	 */
	public void setUsuarioPie(String usuario){

	}
}//end InformeArchivoExcel