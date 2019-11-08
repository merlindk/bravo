package com.dsi.bravo.negocio;


public class Rol {

	private String nombre;

	public Rol(String nombre){
		this.nombre = nombre;
	}

	public void finalize() throws Throwable {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}