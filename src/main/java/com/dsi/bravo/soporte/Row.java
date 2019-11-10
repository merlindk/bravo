package com.dsi.bravo.soporte;

public class Row {
    private String columnaDNI;
    private String columnaNombre;
    private String columnaApellido;

    public Row(String dni, String nombre, String apellido) {
        this.columnaDNI = dni;
        this.columnaNombre = nombre;
        this.columnaApellido = apellido;
    }

    public String getColumnaDNI() {
        return columnaDNI;
    }

    public void setColumnaDNI(String dni) {
        this.columnaDNI = dni;
    }

    public String getColumnaNombre() {
        return columnaNombre;
    }

    public void setColumnaNombre(String nombre) {
        this.columnaNombre = nombre;
    }

    public String getColumnaApellido() {
        return columnaApellido;
    }

    public void setColumnaApellido(String apellido) {
        this.columnaApellido = apellido;
    }

    @Override
    public String toString() {
        return columnaDNI + columnaNombre + columnaApellido;
    }
}
