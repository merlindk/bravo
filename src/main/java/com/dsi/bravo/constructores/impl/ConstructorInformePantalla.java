package com.dsi.bravo.constructores.impl;

import com.dsi.bravo.constantes.Constantes;
import com.dsi.bravo.constructores.IConstructorInformeGuardias;
import com.dsi.bravo.pantallas.PantallaMostrarReporteCumplimientoDeGuardias;
import com.dsi.bravo.soporte.Resultado;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ConstructorInformePantalla implements IConstructorInformeGuardias {

    private PantallaMostrarReporteCumplimientoDeGuardias pantallaMostrarReporteCumplimientoDeGuardias;

    @Override
    public void construirCuerpo(List<Resultado> resultados) {
        for (Resultado resultado : resultados) {
            pantallaMostrarReporteCumplimientoDeGuardias.agregarCuerpo(resultado.getNombre(), resultado.getApellido(), resultado.getPorcentaje());
        }
    }

    @Override
    public void construirEncabezado(LocalDate fechaInicio, LocalDate fechaFin) {
        pantallaMostrarReporteCumplimientoDeGuardias.setFechaDesde(Constantes.MENSAJE_LABEL_FECHA_DESDE + fechaInicio.toString());
        pantallaMostrarReporteCumplimientoDeGuardias.setFechaHasta(Constantes.MENSAJE_LABEL_FECHA_HASTA + fechaFin.toString());
    }

    @Override
    public void construirInforme() {
        pantallaMostrarReporteCumplimientoDeGuardias = new PantallaMostrarReporteCumplimientoDeGuardias();
    }

    @Override
    public void construirPie(String usuario, LocalDateTime fechaHora) {
        pantallaMostrarReporteCumplimientoDeGuardias.setUsuario(Constantes.MENSAJE_LABEL_USUARIO + usuario);
        pantallaMostrarReporteCumplimientoDeGuardias.setFechaGeneracion(Constantes.MENSAJE_LABEL_FECHA_GENERACION + fechaHora.toString());
    }

    public PantallaMostrarReporteCumplimientoDeGuardias obtenerResultado() {

        return pantallaMostrarReporteCumplimientoDeGuardias;
    }
}
