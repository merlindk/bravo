package com.dsi.bravo.informes;


import com.dsi.bravo.soporte.Resultado;

import java.util.ArrayList;
import java.util.List;


public class InformeArchivoPDF {

    private String usuario;
    private String fechaDesde;
    private String fechaHasta;
    private List<Resultado> resultados;
    private String fechaGeneracion;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public List<String> imprimir() {
        List<String> aImprimir = new ArrayList<>();
        aImprimir.add(String.format("Informe de cumplimiento de guardias - Fecha desde: %s - Fecha hasta: %s", fechaDesde, fechaHasta));

        for (Resultado resultado : resultados) {
            aImprimir.add(resultado.getNombre() + " " + resultado.getApellido() + " " + resultado.getPorcentaje());
        }
        aImprimir.add(String.format("Usuario: %s - Fecha generacion: %s", usuario, fechaGeneracion));
        return aImprimir;

    }

}