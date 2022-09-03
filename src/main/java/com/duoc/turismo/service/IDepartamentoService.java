package com.duoc.turismo.service;

import com.duoc.turismo.controller.model.DepartamentoRequest;
import com.duoc.turismo.repository.model.Departamento;
import com.duoc.turismo.repository.model.ServicioDepto;

import java.util.List;

public interface IDepartamentoService {

    //Crear depto
     void save(DepartamentoRequest deptoRequest);

     //Listar depto
    List<Departamento> findByAllDeptos();

    //Listar departamento por region y comuna
    List<Departamento> findByRegionAndComuna(String region, String comuna);

    //Actualizar depto estado
    Departamento updateDeptoEstado(String estado, Integer idDepartamento);

    //Actualizar datos depto
    Departamento updateDatosDepto(Integer valorDiario, Integer cantidadCamas, Integer capacidadHuespedes,
                                  Integer idDepto, String descripcion);

    //Actualizar fotos depto
    void actualizarFotos(DepartamentoRequest departamentoRequest);

     void actualizarServicioDepto(DepartamentoRequest departamentoRequest);

    //Eliminar depto
    void deleteById(Integer idDepto);


}
