package com.dsi.bravo.auth;

import org.springframework.stereotype.Service;

@Service
public class Sesion {

    private Usuario usuario;
    private int fechaDesde;
    private int fechaHasta;

    public Sesion() {
        usuario = new Usuario();
        usuario.setNombre("Merlin Nuñez");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void obtenerNombreUsuario() {

    }
}//end Sesion