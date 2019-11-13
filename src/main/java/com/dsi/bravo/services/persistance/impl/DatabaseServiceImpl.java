package com.dsi.bravo.services.persistance.impl;

import com.dsi.bravo.auth.Usuario;
import com.dsi.bravo.negocio.*;
import com.dsi.bravo.services.persistance.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    private List<Convocatoria> convocatorias = new ArrayList<>();
    private List<Bombero> bomberos = new ArrayList<>();

    @Autowired
    public DatabaseServiceImpl() {
        readBombero();
        readConvocatoria();
    }

    private void readConvocatoria() {
        Scanner fileReader;
        Bombero bombero = null;
        try {
            fileReader = new Scanner(new File("convocatorias.csv"));
        } catch (FileNotFoundException e) {
            return;
        }
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] campos = line.split(",");
            if (bombero == null || bombero.getDni() != Integer.parseInt(campos[0])) {
                bombero = getBomberoFromDni(campos[0]);
            }
            Convocatoria convocatoria = new Convocatoria(Boolean.parseBoolean(campos[1]), LocalDateTime.parse(campos[2]),
                    LocalDateTime.parse(campos[3]), bombero);
            convocatorias.add(convocatoria);
        }
    }

    private void readBombero() {
        Scanner fileReader;
        try {
            fileReader = new Scanner(new File("bomberos.csv"));
        } catch (FileNotFoundException e) {
            return;
        }
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] campos = line.split(",");
            List<Asistencia> asistencias = readAsistencia(campos[3]);
            Bombero bombero = new Bombero(Boolean.parseBoolean(campos[0]), campos[1], campos[2], Integer.parseInt(campos[3]),
                    campos[4], LocalDateTime.parse(campos[5]), campos[6], campos[7],
                    new Usuario(), new Rol(campos[8]), Arrays.asList(), asistencias);
            bomberos.add(bombero);
        }
    }

    private List<Asistencia> readAsistencia(String bombero) {
        Scanner asistenciasReader;
        List<Asistencia> asistencias = new ArrayList<>();
        int wasFound = 0;
        try {
            asistenciasReader = new Scanner(new File("asistencias.csv"));
        } catch (FileNotFoundException e) {
            return null;
        }
        while (asistenciasReader.hasNextLine()) {
            if (wasFound == 2) {
                break;
            }
            String lineAsistencias = asistenciasReader.nextLine();
            String[] camposAsistencias = lineAsistencias.split(",");
            if (camposAsistencias[0].equals(bombero)) {
                asistencias.add(new Asistencia(LocalDateTime.parse(camposAsistencias[1]), LocalDateTime.parse(camposAsistencias[2]),
                        new GuardiaBombero(new Estado("EnCurso"))));
                wasFound = 1;
            } else if (wasFound == 1) {
                wasFound = 2;
            }
        }
        return asistencias;
    }

    @Override
    public List<Bombero> getAllBomberosActivos() {
        return bomberos;
    }

    @Override
    public List<Bombero> getBomberosFromList(List<String> bomberosSeleccionadosDni) {
        List<Bombero> bomberosFinder = new ArrayList<>();
        for (Bombero bombero : bomberos) {
            if (bomberosSeleccionadosDni.contains(String.valueOf(bombero.getDni()))) {
                bomberosFinder.add(bombero);
            }
        }
        return bomberosFinder;
    }

    @Override
    public List<Convocatoria> getConvocatoriaFromBombero(Bombero bombero) {
        List<Convocatoria> convocatoriasBombero = new ArrayList<>();
        for (Convocatoria convocatoria : convocatorias) {
            if (convocatoria.getBombero().equals(bombero)) {
                convocatoriasBombero.add(convocatoria);
            }
        }
        return convocatoriasBombero;
    }

    private Bombero getBomberoFromDni(String dni) {
        for (Bombero bombero : bomberos) {
            if (("" + bombero.getDni()).equals(dni)) {
                return bombero;
            }
        }
        return null;
    }

}
