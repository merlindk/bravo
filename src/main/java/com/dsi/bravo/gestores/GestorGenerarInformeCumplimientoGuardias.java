package com.dsi.bravo.gestores;


import com.dsi.bravo.negocio.Asistencia;
import com.dsi.bravo.negocio.Bombero;
import com.dsi.bravo.negocio.Convocatoria;
import com.dsi.bravo.services.persistance.DatabaseService;
import com.dsi.bravo.soporte.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GestorGenerarInformeCumplimientoGuardias {

    private static final Logger LOG = LoggerFactory.getLogger(GestorGenerarInformeCumplimientoGuardias.class);

    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private List<Bombero> bomberosList;
    private List<List<Convocatoria>> convocatoriasConfirmadas;

    private DatabaseService databaseService;

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


    public void tomarBomberosSeleccionados(List<String> dniList){
        bomberosList = databaseService.getBomberosFromList(dniList);
        buscarYContarConvocatoriasConfirmadas();
        buscarYContarConvocatoriasEfectivas();
    }

    private void buscarYContarConvocatoriasEfectivas() {
        for (int i = 0; i < bomberosList.size(); i++) {
            Bombero bombero = bomberosList.get(i);
            int countAsistencias = bombero.obtenerAsistenciasEfectivas(convocatoriasConfirmadas.get(i));
        }
    }

    private void buscarYContarConvocatoriasConfirmadas() {
        // TODO Por ahi mejor sacar este doble array y convertirlo en un contador simple.
        convocatoriasConfirmadas = new ArrayList<>();
        for (Bombero bombero : bomberosList) {
            convocatoriasConfirmadas.add(bombero.obtenerConvocatoriasConfirmadas(databaseService.getConvocatoriaFromBombero(bombero), fechaDesde, fechaHasta));
        }
    }
}