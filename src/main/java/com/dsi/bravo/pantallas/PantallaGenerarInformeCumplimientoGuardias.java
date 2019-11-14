package com.dsi.bravo.pantallas;

import com.dsi.bravo.gestores.GestorGenerarInformeCumplimientoGuardias;
import com.dsi.bravo.pantallas.ayudantes.AyudantePantalla;
import com.dsi.bravo.pantallas.ayudantes.ControladorDeEscenas;
import com.dsi.bravo.soporte.Row;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.CheckListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class PantallaGenerarInformeCumplimientoGuardias implements Initializable {

    public Button btnGenerarReporte;
    public CheckListView<Row> chckTblBomberos;
    public DatePicker selFechaDesde;
    public DatePicker selFechaHasta;
    public Button btnSelFechas;
    public AnchorPane chartPane;
    public AnchorPane tablePane;
    private ControladorDeEscenas controladorDeEscenas;
    private GestorGenerarInformeCumplimientoGuardias gestorGenerarInformeCumplimientoGuardias;
    private AyudantePantalla ayudantePantalla;
    private ObservableList<Row> listaBomberos = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chckTblBomberos.setItems(listaBomberos);
        selFechaDesde.setValue(LocalDate.parse("1970-01-01"));
        selFechaHasta.setValue(LocalDate.now());

        selFechaDesde.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue){
                selFechaDesde.setValue(selFechaDesde.getConverter().fromString(selFechaDesde.getEditor().getText()));
            }
        });

        selFechaHasta.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue){
                selFechaHasta.setValue(selFechaHasta.getConverter().fromString(selFechaHasta.getEditor().getText()));
            }
        });

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

        tablePane.setVisible(true);

    }

    private void mostrarAlerta(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR, error, ButtonType.CLOSE);
        alert.showAndWait();
    }

    public void generarReporte(ActionEvent actionEvent) throws IOException {
        chartPane.setVisible(true);
        Collection<Integer> checkeadosIndexes = chckTblBomberos.getCheckModel().getCheckedIndices();
        List<String> dniList = new ArrayList<>();
        checkeadosIndexes.forEach((i) -> dniList.add(chckTblBomberos.getCheckModel().getItem(i).getColumnaDNI()));
        gestorGenerarInformeCumplimientoGuardias.tomarBomberosSeleccionados(dniList);

        PantallaMostrarReporteCumplimientoDeGuardias pantallaMostrarReporteCumplimientoDeGuardias = gestorGenerarInformeCumplimientoGuardias.mostrarResultados();

        lanzarPantalla(actionEvent.getSource(), pantallaMostrarReporteCumplimientoDeGuardias);
    }

    private void lanzarPantalla(Object source, PantallaMostrarReporteCumplimientoDeGuardias pantallaMostrarReporteCumplimientoDeGuardias) throws IOException {
        pantallaMostrarReporteCumplimientoDeGuardias.setGestorGenerarInformeCumplimientoGuardias(gestorGenerarInformeCumplimientoGuardias);
        Stage appStage;
        Parent root;
        if (source == btnGenerarReporte) {
            appStage = (Stage) btnGenerarReporte.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/Reporte.fxml"));
            loader.setController(pantallaMostrarReporteCumplimientoDeGuardias);
            pantallaMostrarReporteCumplimientoDeGuardias.setPreviousScene(appStage.getScene());
            root = loader.load();

            Scene scene = new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }
    }


    public void seleccionarTodos(ActionEvent actionEvent) {
        chckTblBomberos.getCheckModel().checkAll();
    }

    public void deseleccionarTodos(ActionEvent actionEvent) {
        chckTblBomberos.getCheckModel().clearChecks();
    }

    @Autowired
    public void setGestorGenerarInformeCumplimientoGuardias(GestorGenerarInformeCumplimientoGuardias gestorGenerarInformeCumplimientoGuardias) {
        this.gestorGenerarInformeCumplimientoGuardias = gestorGenerarInformeCumplimientoGuardias;
    }

    @Autowired
    public void setAyudantePantalla(AyudantePantalla ayudantePantalla) {
        this.ayudantePantalla = ayudantePantalla;
    }

    @Autowired
    public void setControladorDeEscenas(ControladorDeEscenas controladorDeEscenas) {
        this.controladorDeEscenas = controladorDeEscenas;
    }
}
