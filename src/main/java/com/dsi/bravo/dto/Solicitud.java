package com.dsi.bravo.dto;

import java.util.ArrayList;

public class Solicitud {
    ArrayList<Long> bomberos = new ArrayList<>();
    private String fechaDesde;
    private String fechaHasta;


    // Getter Methods

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    // Setter Methods

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public ArrayList<Long> getBomberos() {
        return bomberos;
    }

    public void setBomberos(ArrayList<Long> bomberos) {
        this.bomberos = bomberos;
    }
}
