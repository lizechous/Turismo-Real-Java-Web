package com.duoc.turismo.service;

import com.duoc.turismo.controller.model.DepartamentoRequest;
import com.duoc.turismo.repository.model.Departamento;
import com.duoc.turismo.repository.model.Inventario;
import com.duoc.turismo.repository.model.ServicioDepto;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IDepartamentoService {

    //Crear depto
     void save(DepartamentoRequest deptoRequest);

     //Listar todos los depto
    List<Departamento> buscarDepartamento(Boolean estado, String region, String comuna);

    //Buscar departamento por region y comuna
    List<Departamento> findByRegionAndComuna(String region, String comuna);

    //Buscar depto por nombre depto
    List<Departamento> findByNombreDepto(String nombreDepto);

    //Buscar depto por id
    Departamento findByIdDepto(Integer id);

    //Actualizar depto estado
    Boolean updateDeptoEstado(Boolean estado, Integer idDepartamento);

    //Actualizar datos depto
    Boolean updateDatosDepto(Departamento departamento);

    //Actualizar fotos depto, desde depto
    void actualizarFotos(Departamento departamentoRequest);

    //Actualizar inventario desde departamento
    void actualizarInventario(Inventario inventario);

    //Eliminar depto
    //void deleteById(Integer idDepto);

    //Actualizar servicio depto, desde depto
    void actualizarServicioDepto(Departamento departamentoRequest);

    //Actualizar condiciones de uso
    void actualizarCondiciones(Departamento departamentoRequest);

    List<String> getComunasDepto();

    List<Departamento> buscarDeptosDisponibles(Date fechaInicio,
                                               Date fechaFin,
                                               String comuna,
                                               Integer valorMaximo);

}
