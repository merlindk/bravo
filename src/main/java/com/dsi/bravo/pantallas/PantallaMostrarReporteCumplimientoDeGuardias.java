package com.dsi.bravo.pantallas;

import com.dsi.bravo.gestores.GestorGenerarInformeCumplimientoGuardias;
import com.dsi.bravo.soporte.Resultado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PantallaMostrarReporteCumplimientoDeGuardias implements Initializable {

    private GestorGenerarInformeCumplimientoGuardias gestorGenerarInformeCumplimientoGuardias;

    private String usuario;
    private String fechaDesde;
    private String fechaHasta;
    private List<Resultado> resultados;
    private String fechaGeneracion;
    private Scene previousScene;

    @FXML
    private AnchorPane chartPanel;
    @FXML
    private Label lblFechaDesde;
    @FXML
    private Label lblFechaHasta;
    @FXML
    private Label lblUsuario;
    @FXML
    private Label lblFechaGeneracion;
    @FXML
    private Button btnBack;

    private ObservableList<XYChart.Data<String, Number>> listaChart = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prepararChart();

        lblFechaDesde.setText(fechaDesde);
        lblFechaHasta.setText(fechaHasta);
        lblUsuario.setText(usuario);
        lblFechaGeneracion.setText(fechaGeneracion);
    }

    public void exportarPDF(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Export to PDF");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PDF", ".pdf");
        chooser.getExtensionFilters().add(filter);
        File file = chooser.showSaveDialog(btnBack.getScene().getWindow());
        if (file != null) {
            gestorGenerarInformeCumplimientoGuardias.tomarOpcionImpresionPDF(file.getAbsolutePath());
        }
    }


    public void exportarExcel(ActionEvent actionEvent) {

    }

    public void volver(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        Stage appStage;
        if (source == btnBack) {
            appStage = (Stage) btnBack.getScene().getWindow();

            appStage.setScene(previousScene);
            appStage.show();

        }
    }

    private void prepararChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Bombero");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Cumplimiento");
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<>();
        dataSeries1.setName("Cumplimiento X Bombero");

        dataSeries1.setData(listaChart);
        barChart.getData().add(dataSeries1);
        barChart.setAnimated(false); // Si queres la animacion revisa bien que ande el cuadro
        chartPanel.getChildren().add(barChart);
    }

    public void agregarCuerpo(String nombre, String apellido, float porcentaje) {
        listaChart.add(new XYChart.Data<>(nombre + " " + apellido, porcentaje));
    }

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

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

    public void setGestorGenerarInformeCumplimientoGuardias(GestorGenerarInformeCumplimientoGuardias gestorGenerarInformeCumplimientoGuardias) {
        this.gestorGenerarInformeCumplimientoGuardias = gestorGenerarInformeCumplimientoGuardias;
    }
}
