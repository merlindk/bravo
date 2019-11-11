package com.dsi.bravo.gestores;


import com.dsi.bravo.negocio.Bombero;
import com.dsi.bravo.services.persistance.DatabaseService;
import com.dsi.bravo.soporte.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class GestorGenerarInformeCumplimientoGuardias {

    private static final Logger LOG = LoggerFactory.getLogger(GestorGenerarInformeCumplimientoGuardias.class);

    private LocalDate fechaDesde;
    private LocalDate fechaHasta;

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
        List<Bombero> bomberosList = databaseService.getBomberosFromList(dniList);
        for (Bombero bombero : bomberosList) {
            bombero.obtenerConvocatoriasConfirmadas();
        }
    }
}