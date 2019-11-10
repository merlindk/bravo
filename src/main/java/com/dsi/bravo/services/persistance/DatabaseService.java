package com.dsi.bravo.services.persistance;

import com.dsi.bravo.negocio.Bombero;

import java.util.List;

public interface DatabaseService {

    List<Bombero> getAllBomberosActivos();

    List<Bombero> getBomberosFromList(List<String> bomberosSeleccionados);
}
