package com.dsi.bravo.dto;

import java.util.ArrayList;

public class Solicitud {
        private String fechaDesde;
        private String fechaHasta;
        ArrayList<Long> bomberos = new ArrayList <> ();


        // Getter Methods

        public String getFechaDesde() {
            return fechaDesde;
        }

        public String getFechaHasta() {
            return fechaHasta;
        }

        // Setter Methods

        public void setFechaDesde(String fechaDesde) {
            this.fechaDesde = fechaDesde;
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
