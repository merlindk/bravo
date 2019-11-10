package com.dsi.bravo.soporte;

public class Row {
    private String columna1;
    private String columna2;
    private String columna3;

    public Row(String columna1, String columna2, String columna3) {
        this.columna1 = columna1;
        this.columna2 = columna2;
        this.columna3 = columna3;
    }

    public String getColumna1() {
        return columna1;
    }

    public void setColumna1(String columna1) {
        this.columna1 = columna1;
    }

    public String getColumna2() {
        return columna2;
    }

    public void setColumna2(String columna2) {
        this.columna2 = columna2;
    }

    public String getColumna3() {
        return columna3;
    }

    public void setColumna3(String columna3) {
        this.columna3 = columna3;
    }

    @Override
    public String toString() {
        return columna1 + columna2 + columna3;
    }
}
