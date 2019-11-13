package com.dsi.bravo.gestores;


import com.dsi.bravo.auth.Sesion;
import com.dsi.bravo.constructores.impl.ConstructorInformePDF;
import com.dsi.bravo.constructores.impl.ConstructorInformePantalla;
import com.dsi.bravo.directores.DirectorConstructorInformeGuardias;
import com.dsi.bravo.externos.ImpresoraPDF;
import com.dsi.bravo.informes.InformeArchivoPDF;
import com.dsi.bravo.negocio.Bombero;
import com.dsi.bravo.pantallas.PantallaMostrarReporteCumplimientoDeGuardias;
import com.dsi.bravo.services.persistance.DatabaseService;
import com.dsi.bravo.soporte.Resultado;
import com.dsi.bravo.soporte.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GestorGenerarInformeCumplimientoGuardias {

    private static final Logger LOG = LoggerFactory.getLogger(GestorGenerarInformeCumplimientoGuardias.class);

    private static final String TEMPLATE_RESULTADO = "%s, %s: %d";

    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private List<Resultado> resultados;

    private DatabaseService databaseService;
    private Sesion sesion;
    private ImpresoraPDF impresoraPDF;

    @Autowired
    public GestorGenerarInformeCumplimientoGuardias(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public boolean tomarSeleccionFechas(LocalDate fechaDesde, LocalDate fechaHasta) {
        boolean fechaCorrecta = (fechaDesde != null && fechaHasta != null) && fechaDesde.isBefore(fechaHasta);
        if (fechaCorrecta) {
            this.fechaDesde = fechaDesde;
            this.fechaHasta = fechaHasta;
        }
        return fechaCorrecta;
    }

    public List<Row> consultarBomberosActivos() {
        List<Row> filasBomberos = new ArrayList<>();
        for (Bombero bombero : databaseService.getAllBomberosActivos()) {
            filasBomberos.add(new Row("" + bombero.getDni(), bombero.getNombre(), bombero.getApellido()));
        }
        return filasBomberos;
    }

    public void tomarBomberosSeleccionados(List<String> dniList) {
        List<Bombero> bomberosList = databaseService.getBomberosFromList(dniList);
        buscarYContarConvocatoriasConfirmadas(bomberosList);
        resultados = buscarYContarConvocatoriasEfectivas(bomberosList);
    }

    public PantallaMostrarReporteCumplimientoDeGuardias mostrarResultados() {
        ConstructorInformePantalla constructorInformeGuardias = new ConstructorInformePantalla();
        DirectorConstructorInformeGuardias directorConstructorInformeGuardias = new DirectorConstructorInformeGuardias(constructorInformeGuardias);

        directorConstructorInformeGuardias.construir(fechaDesde, fechaHasta, resultados, sesion.getUsuario().getNombre(), LocalDateTime.now());

        return constructorInformeGuardias.obtenerResultado();
    }

    public void tomarOpcionImpresionPDF(String absolutePath) {
        ConstructorInformePDF constructorInformeGuardias = new ConstructorInformePDF();
        DirectorConstructorInformeGuardias directorConstructorInformeGuardias = new DirectorConstructorInformeGuardias(constructorInformeGuardias);

        directorConstructorInformeGuardias.construir(fechaDesde, fechaHasta, resultados, sesion.getUsuario().getNombre(), LocalDateTime.now());

        InformeArchivoPDF informeArchivoPDF = constructorInformeGuardias.obtenerResultado();
        List<String> aImprimir = informeArchivoPDF.imprimir();

        impresoraPDF.imprimir(absolutePath, aImprimir);
    }

    private List<Resultado> buscarYContarConvocatoriasEfectivas(List<Bombero> bomberosList) {
        List<Resultado> resultados = new ArrayList<>();
        for (Bombero bombero : bomberosList) {
            int countAsistencias = bombero.obtenerAsistenciasEfectivas();
            int convocatorias = bombero.getConvocatorias().size();
            float cumplimiento = (convocatorias != 0) ? countAsistencias / bombero.getConvocatorias().size() : 0;
            cumplimiento *= 100;
            String nombre = bombero.getNombre();
            String apellido = bombero.getApellido();
            resultados.add(new Resultado(nombre, apellido, cumplimiento));
        }
        return resultados;
    }

    private void buscarYContarConvocatoriasConfirmadas(List<Bombero> bomberosList) {
        for (Bombero bombero : bomberosList) {
            bombero.obtenerConvocatoriasConfirmadas(databaseService.getConvocatoriaFromBombero(bombero), fechaDesde, fechaHasta);
        }
    }

    @Autowired
    public void setSession(Sesion sesion) {
        this.sesion = sesion;
    }

    @Autowired
    public void setImpresoraPDF(ImpresoraPDF impresoraPDF) {
        this.impresoraPDF = impresoraPDF;
    }
}