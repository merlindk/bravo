package com.dsi.bravo.soporte;

public class Resultado {

    private String nombre;
    private String apellido;
    private float porcentaje;

    public Resultado(String nombre, String apellido, float porcentaje) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public float getPorcentaje() {
        return porcentaje;
    }
}
