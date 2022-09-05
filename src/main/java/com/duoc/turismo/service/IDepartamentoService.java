package com.duoc.turismo.service;

import com.duoc.turismo.controller.model.DepartamentoRequest;
import com.duoc.turismo.repository.model.Departamento;
import com.duoc.turismo.repository.model.Inventario;
import com.duoc.turismo.repository.model.ServicioDepto;

import java.util.List;

public interface IDepartamentoService {

    //Crear depto
     void save(DepartamentoRequest deptoRequest);

     //Listar todos los depto
    List<Departamento> findByAllDeptos();

    //Buscar departamento por region y comuna
    List<Departamento> findByRegionAndComuna(String region, String comuna);

    //Buscar depto por nombre depto
    List<Departamento> findByNombreDepto(String nombreDepto);

    //Actualizar depto estado
    Departamento updateDeptoEstado(String estado, Integer idDepartamento);

    //Actualizar datos depto
    Departamento updateDatosDepto(Integer valorDiario, Integer cantidadCamas, Integer capacidadHuespedes,
                                  Integer idDepto, String descripcion);

    //Actualizar fotos depto, desde depto
    void actualizarFotos(DepartamentoRequest departamentoRequest);

    //Actualizar servicio depto, desde depto
     void actualizarServicioDepto(DepartamentoRequest departamentoRequest);

     //Actualizar condiciones de uso
    void actualizarCondiciones(DepartamentoRequest departamentoRequest);

    //Actualizar inventario desde departamento
    void actualizarInventario(Inventario inventario);

    //Eliminar depto
    void deleteById(Integer idDepto);



}
