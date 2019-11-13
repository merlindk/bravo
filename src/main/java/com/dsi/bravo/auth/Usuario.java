package com.dsi.bravo.auth;

/**
 * @author Merlin
 * @version 1.0
 * @created 04-Nov-2019 10:21:04 PM
 */
public class Usuario {

    private Perfil perfil;
    private int contraseña;
    private int fechaAlta;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}