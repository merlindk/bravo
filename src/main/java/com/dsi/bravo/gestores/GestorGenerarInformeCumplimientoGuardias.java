package com.dsi.bravo.gestores;


import com.dsi.bravo.dto.Solicitud;
import com.dsi.bravo.negocio.Bombero;
import com.dsi.bravo.services.format.DateFormatter;
import com.dsi.bravo.services.persistance.DatabaseService;
import com.dsi.bravo.services.validation.DateValidationService;
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
    private DateValidationService dateValidationService;
    private DateFormatter dateFormatter;

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


    public String obtenerReporteAsistencia(Solicitud solicitud) {
        LocalDate desde = dateFormatter.formatString(solicitud.getFechaDesde());
        LocalDate hasta = dateFormatter.formatString(solicitud.getFechaHasta());
        if (!dateValidationService.validate(desde, hasta)) {
            throw new IllegalArgumentException("La fecha desde debe ser anterior a la fecha hasta");
        }

        List<Bombero> bomberosAReportar = databaseService.getBomberosFromList(solicitud.getBomberos());

        return null;
    }
}