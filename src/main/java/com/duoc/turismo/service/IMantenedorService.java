package com.duoc.turismo.service;

import com.duoc.turismo.repository.model.Comuna;
import com.duoc.turismo.repository.model.Departamento;
import com.duoc.turismo.repository.model.Mantencion;
import com.duoc.turismo.repository.model.Region;

import java.util.List;

public interface IMantenedorService {

    public Boolean cargarRegionesComunas();

    List<Comuna> findByAllComunas(String region);

    List<Region> findByAllRegion();

    void crearMantencion(Mantencion mantencion);

    List<Mantencion> buscarMantencionesDepto(Integer id);

    Mantencion buscarMantencionId(Integer id);

    void modificarFotosMantencion(Mantencion mantencion);

    void modificarMantencion(Mantencion mantencion);
}
