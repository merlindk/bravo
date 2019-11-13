package com.dsi.bravo.pantallas.ayudantes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ControladorDeEscenas {

    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    public void addScreen(String name, Pane pane) {
        screenMap.put(name, pane);
    }

    public void removeScreen(String name) {
        screenMap.remove(name);
    }

    public void activate(String name) {
        main.setRoot(screenMap.get(name));
    }

    public void setMain(Scene main) {
        this.main = main;
    }
}
