package com.dsi.bravo.services.persistance.impl;

import com.dsi.bravo.auth.Usuario;
import com.dsi.bravo.negocio.Asistencia;
import com.dsi.bravo.negocio.Bombero;
import com.dsi.bravo.negocio.Rol;
import com.dsi.bravo.services.persistance.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    private List<Bombero> bomberos = new ArrayList<>();

    @Autowired
    public DatabaseServiceImpl() {
        Bombero bombero1 = new Bombero(true, "Nuñez", "Av Siempre viva 123", 35676585,
                "tiorrico11@gmail.com", LocalDateTime.parse("1991-01-25T06:30:00"), "Merlin", "03541330188",
                new Usuario(), new Rol("Jefe de Bomberos"), Arrays.asList(), Arrays.asList(new Asistencia(LocalDateTime.parse("2019-10-20T06:30:00"), LocalDateTime.parse("2019-10-20T17:30:00"))));

        bomberos.add(bombero1);
    }

    @Override
    public List<Bombero> getAllBomberosActivos() {
        List<Bombero> bomberos = new ArrayList<>();

//        for (BomberoEntity entity : bomberoRepository.findAll()) {
//            if (entity.isActivo()) {
//                bomberos.add(mapBombero(entity));
//            }
//        }

        return bomberos;
    }

    @Override
    public List<Bombero> getBomberosFromList(List<Long> bomberosSeleccionados) {
//        List<Bombero> bomberos = new ArrayList<>();
//        for (BomberoEntity entity : bomberoRepository.findAllById(bomberosSeleccionados)) {
//            bomberos.add(mapBombero(entity));
//        }
        return bomberos;
    }


}
