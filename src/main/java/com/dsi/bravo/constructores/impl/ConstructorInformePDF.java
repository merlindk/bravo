package com.dsi.bravo.constructores.impl;


import com.dsi.bravo.constantes.Constantes;
import com.dsi.bravo.constructores.IConstructorInformeGuardias;
import com.dsi.bravo.informes.InformeArchivoPDF;
import com.dsi.bravo.soporte.Resultado;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class ConstructorInformePDF implements IConstructorInformeGuardias {

    private InformeArchivoPDF informe;

    public void construirCuerpo(List<Resultado> resultados) {
        informe.setResultados(resultados);
    }

    public void construirEncabezado(LocalDate fechaInicio, LocalDate fechaFin) {
        informe.setFechaDesde(Constantes.MENSAJE_LABEL_FECHA_DESDE + fechaInicio.toString());
        informe.setFechaHasta(Constantes.MENSAJE_LABEL_FECHA_HASTA + fechaFin.toString());
    }

    public void construirInforme() {
        informe = new InformeArchivoPDF();
    }

    public void construirPie(String usuario, LocalDateTime fechaHora) {
        informe.setUsuario(Constantes.MENSAJE_LABEL_USUARIO + usuario);
        informe.setFechaGeneracion(Constantes.MENSAJE_LABEL_FECHA_GENERACION + fechaHora.toString());
    }

    public InformeArchivoPDF obtenerResultado() {
        return informe;
    }
}