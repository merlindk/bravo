package com.dsi.bravo.pantallas;

import com.dsi.bravo.gestores.GestorGenerarInformeCumplimientoGuardias;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PantallaGenerarInformeCumplimientoGuardias {

    private GestorGenerarInformeCumplimientoGuardias gestorGenerarInformeCumplimientoGuardias;

    public Button btnButton;
    public TableView tblSelBomberos;
    public DatePicker selFechaDesde;
    public DatePicker selFechaHasta;
    public Button btnSelFechas;

    public void seleccionarFechas(ActionEvent actionEvent) {

    }

    @Autowired
    public void setGestorGenerarInformeCumplimientoGuardias(GestorGenerarInformeCumplimientoGuardias gestorGenerarInformeCumplimientoGuardias) {
        this.gestorGenerarInformeCumplimientoGuardias = gestorGenerarInformeCumplimientoGuardias;
    }
}
