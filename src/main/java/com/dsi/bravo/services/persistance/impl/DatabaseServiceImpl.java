package com.dsi.bravo.services.persistance.impl;

import com.dsi.bravo.auth.Usuario;
import com.dsi.bravo.negocio.Asistencia;
import com.dsi.bravo.negocio.Bombero;
import com.dsi.bravo.negocio.Convocatoria;
import com.dsi.bravo.negocio.Rol;
import com.dsi.bravo.services.persistance.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    private List<Convocatoria> convocatorias = new ArrayList<>();
    private List<Bombero> bomberos = new ArrayList<>();

    @Autowired
    public DatabaseServiceImpl() {
        Scanner fileReader;
        try {
            fileReader = new Scanner(new File("bomberos.csv"));
        } catch (FileNotFoundException e) {
            return;
        }
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] campos = line.split(",");
            Bombero bombero = new Bombero(Boolean.parseBoolean(campos[0]), campos[1], campos[2], Integer.parseInt(campos[3]),
                    campos[4], LocalDateTime.parse(campos[5]), campos[6], campos[7],
                    new Usuario(), new Rol(campos[8]), Arrays.asList(),
                    Arrays.asList(new Asistencia(LocalDateTime.parse(campos[9]), LocalDateTime.parse(campos[10]))));
            bomberos.add(bombero);
        }
        try {
            fileReader = new Scanner(new File("convocatorias.csv"));
        } catch (FileNotFoundException e) {
            return;
        }
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] campos = line.split(",");
            Convocatoria convocatoria = new Convocatoria(Boolean.parseBoolean(campos[0]), LocalDateTime.parse(campos[1]),
                    LocalDateTime.parse(campos[2]), getBomberoFromDni(campos[3]));
            convocatorias.add(convocatoria);
        }
    }

    @Override
    public List<Bombero> getAllBomberosActivos() {
        return bomberos;
    }

    @Override
    public List<Bombero> getBomberosFromList(List<String> bomberosSeleccionadosDni) {
        List<Bombero> bomberosFinder = new ArrayList<>();
        for (Bombero bombero : bomberos) {
            if (bomberosSeleccionadosDni.contains(bombero.getDni())) {
                bomberosFinder.add(bombero);
            }
        }
        return bomberosFinder;
    }

    @Override
    public List<Convocatoria> getConvocatoriaFromBombero(Bombero bombero) {
        List<Convocatoria> convocatoriasBombero = new ArrayList<>();
        for (Convocatoria convocatoria: convocatorias) {
            if(convocatoria.getBombero().equals(bombero)){
                convocatoriasBombero.add(convocatoria);
            }
        }
        return convocatoriasBombero;
    }

    private Bombero getBomberoFromDni(String dni){
        for (Bombero bombero : bomberos) {
            if(("" + bombero.getDni()).equals(dni)){
                return bombero;
            }
        }
        return null;
    }

}
