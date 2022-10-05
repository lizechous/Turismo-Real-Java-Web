package com.duoc.turismo.service;

import com.duoc.turismo.repository.model.ServicioDepto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IServicioDeptoService {

    //Guardar todos los servicios
    public void save(ServicioDepto servicioDepto);

    //Listar servicios
    List<ServicioDepto> findAll();

    //Actualizar servicio
    ServicioDepto updateServicioDepto(String tipoServicioDepto, Integer idServicioDepto);

    //Eliminar servicio
    void deleteById(Integer idServicioDepto);

}
