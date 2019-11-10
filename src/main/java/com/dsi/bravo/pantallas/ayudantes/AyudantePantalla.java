package com.dsi.bravo.pantallas.ayudantes;

import com.dsi.bravo.soporte.Row;
import javafx.scene.control.cell.CheckBoxListCell;
import org.controlsfx.control.CheckListView;
import org.springframework.stereotype.Service;

@Service
public class AyudantePantalla {

    public void prepareListView(CheckListView<Row> tblSelBomberos) {
        tblSelBomberos.setCellFactory(listView -> new CheckBoxListCell<>(tblSelBomberos::getItemBooleanProperty) {
            @Override
            public void updateItem(Row bombero, boolean empty) {
                super.updateItem(bombero, empty);
                if (bombero != null) {
                    setText(bombero.getColumna1() + " " + bombero.getColumna2() + " " + bombero.getColumna3());
                } else {
                    setText("");
                }
            }
        });
    }
}
