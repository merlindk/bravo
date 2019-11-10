package com.dsi.bravo.pantallas;

import com.dsi.bravo.gestores.GestorGenerarInformeCumplimientoGuardias;
import com.dsi.bravo.pantallas.ayudantes.AyudantePantalla;
import com.dsi.bravo.soporte.Row;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import org.controlsfx.control.CheckListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class PantallaGenerarInformeCumplimientoGuardias implements Initializable {

    public CheckListView<Row> chckTblBomberos;
    public DatePicker selFechaDesde;
    public DatePicker selFechaHasta;
    public Button btnSelFechas;
    private GestorGenerarInformeCumplimientoGuardias gestorGenerarInformeCumplimientoGuardias;
    private AyudantePantalla ayudantePantalla;
    private ObservableList<Row> listaBomberos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chckTblBomberos.setItems(listaBomberos);
    }

    public void seleccionarFechas(ActionEvent actionEvent) {

        //Solicitamos al gestor que valide las fechas y las almacene
        if (!gestorGenerarInformeCumplimientoGuardias.tomarSeleccionFechas(selFechaDesde.getValue(), selFechaHasta.getValue())) {
            mostrarAlerta("Las fechas son incorrectas");
            return;
        }

        //Solicitamos al gestor la lista de bomberos activos
        List<Row> filasBomberos = gestorGenerarInformeCumplimientoGuardias.consultarBomberosActivos();

        //Populamos los componentes visuales
        ayudantePantalla.prepareListView(chckTblBomberos);
        listaBomberos.clear();
        listaBomberos.addAll(filasBomberos);

        chckTblBomberos.setDisable(false);
        chckTblBomberos.setVisible(true);

    }

    private void mostrarAlerta(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR, error, ButtonType.CLOSE);
        alert.showAndWait();
    }

    public void generarReporte(ActionEvent actionEvent) {
        Collection<Integer> checkeadosIndexes = chckTblBomberos.getCheckModel().getCheckedIndices();
        List<String> dniList = new ArrayList<String>();
        checkeadosIndexes.forEach((i) -> dniList.add(chckTblBomberos.getCheckModel().getItem(i).getColumnaDNI()));
        gestorGenerarInformeCumplimientoGuardias.tomarBomberosSeleccionados(dniList);
    }

    @Autowired
    public void setGestorGenerarInformeCumplimientoGuardias(GestorGenerarInformeCumplimientoGuardias gestorGenerarInformeCumplimientoGuardias) {
        this.gestorGenerarInformeCumplimientoGuardias = gestorGenerarInformeCumplimientoGuardias;
    }

    @Autowired
    public void setAyudantePantalla(AyudantePantalla ayudantePantalla) {
        this.ayudantePantalla = ayudantePantalla;
    }


}
