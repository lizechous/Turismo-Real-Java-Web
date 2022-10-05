package com.duoc.turismo.service;

import com.duoc.turismo.controller.model.DepartamentoRequest;
import com.duoc.turismo.controller.model.FotoDeptoRequest;
import com.duoc.turismo.repository.*;
import com.duoc.turismo.repository.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DepartamentoImpl implements IDepartamentoService{

    @Autowired
    private IDepartamentoRepo deptoRepo;

    @Autowired
    private IFotoDeptoRepo iFotoDeptoRepo;

    @Autowired
    private IInventarioRepo iInventarioRepo;

    @Autowired
    private IElementoRepo iElementoRepo;

    @Autowired
    private IServicioDeptoRepo iServicioDeptoRepo;

    @Autowired
    private ICondicionesDeUsoRepo iCondicionesDeUsoRepo;

    //MODIFICAR SERVICIO DEPTO
    @Override
    public void actualizarServicioDepto(Departamento departamentoRequest) {

        Departamento deptoGuardado = deptoRepo.findByIdDepartamento(departamentoRequest.getIdDepartamento());
        for(ServicioDepto servicio: departamentoRequest.getServicioDeptoList()){ //fotoDeptorequestList***
            if(servicio.getAccion() == null){
                continue;
            }
            ServicioDepto servicioBD = iServicioDeptoRepo.findByIdServicioDepto(servicio.getIdServicioDepto());
            switch (servicio.getAccion()){
                case AGREGAR:
                    servicioBD.getDepartamentoList().add(deptoGuardado);
                    iServicioDeptoRepo.save(servicioBD);
                    break;
                case ELIMINAR:
                    servicioBD.getDepartamentoList().removeIf(x -> x.getIdDepartamento() == deptoGuardado.getIdDepartamento());
                    iServicioDeptoRepo.save(servicioBD);
                    break;
            }
        }
    }

    //MODIFICAR CONDICIONES DE USO
    @Override
    public void actualizarCondiciones(Departamento departamentoRequest){
        Departamento deptoGuardado = deptoRepo.findByIdDepartamento(departamentoRequest.getIdDepartamento());
        for(CondicionesDeUso condicion: departamentoRequest.getCondicionesDeUsoList()){ //fotoDeptorequestList***
            if(condicion.getAccion() == null){
                continue;
            }
            CondicionesDeUso condicionBD = iCondicionesDeUsoRepo.findByIdCondicion(condicion.getIdCondicion());
            switch (condicion.getAccion()) {
                case AGREGAR:
                    condicionBD.getDepartamentoList().add(deptoGuardado);
                    iCondicionesDeUsoRepo.save(condicionBD);
                    break;
                case ELIMINAR:
                    condicionBD.getDepartamentoList().removeIf(x -> x.getIdDepartamento() == deptoGuardado.getIdDepartamento());
                    iCondicionesDeUsoRepo.save(condicionBD);
                    break;
            }
        }
    }

    @Override
    public List<String> getComunasDepto() {
        return deptoRepo.getComunasDepto();
    }

    @Override
    public List<Departamento> buscarDeptosDisponibles(Date fechaInicio, Date fechaFin, String comuna, Integer valorMaximo) {
        return deptoRepo.buscarDepartamentosDisponibles(fechaInicio, fechaFin, comuna, valorMaximo);
    }

    //METODO CREAR DEPARTAMENTO
    @Override
    public void save(DepartamentoRequest deptoRequest) {
        Departamento depto = new Departamento();
        depto.setCantidadBanios(deptoRequest.getCantidadBanios());
        depto.setCantidadCamas(deptoRequest.getCantidadCamas());
        depto.setCantidadHabitaciones(deptoRequest.getCantidadHabitaciones());
        depto.setComuna(deptoRequest.getComuna());
        depto.setRegion(deptoRequest.getRegion());
        depto.setDimensiones(deptoRequest.getDimensiones());
        depto.setNombreDepto(deptoRequest.getNombreDepto());
        depto.setCapacidadHuespedes(deptoRequest.getCapacidadHuespedes());
        depto.setDescripcion(deptoRequest.getDescripcion());
        depto.setEstado(true);
        depto.setDireccion(deptoRequest.getDireccion());
        depto.setValorDiario(deptoRequest.getValorDiario());

        Departamento deptoGuardado = deptoRepo.save(depto);

        // asigno los servicios al depto guardado
        for(ServicioDepto servicioDepto: deptoRequest.getServicioDeptoList()){
            // obtengo el servicio del depto almacenado en la bd mediante el id que viene en el request
            ServicioDepto servicioDeptoGuardado = iServicioDeptoRepo.getReferenceById(servicioDepto.getIdServicioDepto());
            // le asigno el departamento guardado al servicio que obtuve
            servicioDeptoGuardado.getDepartamentoList().add(deptoGuardado);
            // guardo el servicio, pero ahora con el depto asignado. Con esto se crea un registro en la tabla detalle_depto_servicio
            iServicioDeptoRepo.save(servicioDeptoGuardado);
        }

        // guardo las fotos

        for (FotoDeptoRequest fotoDeptoRequest: deptoRequest.getFotoDeptoList()){
            FotoDepto foto = new FotoDepto();
            foto.setTituloFotoDepto(fotoDeptoRequest.getTituloFotoDepto());
            String fotoBase64 = fotoDeptoRequest.getFotoDepto().split(",")[1];
            byte[] fotoByte = Base64.getDecoder().decode(fotoBase64);
            try {
                foto.setFotoDepto(new SerialBlob(fotoByte));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            foto.setDepartamento(deptoGuardado);
            iFotoDeptoRepo.save(foto);
        }

        // creo el inventario vacio, ya que los elementos necesitan tener un inventario creado
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);

        Inventario inventario = new Inventario();
        inventario.setDepartamento(deptoGuardado);
        inventario.setFechaInventario(strDate);
        Inventario inventarioGuardado = iInventarioRepo.save(inventario);

        // ahora si puedo crear los elementos, ya que el inventario ya fue creado,
        // pero debo setear el inventario a cada elemento y guardarlo
        for (Elemento elemento: deptoRequest.getInventario().getElementoList()){
            elemento.setInventario(inventarioGuardado);
            iElementoRepo.save(elemento);
        }

        for(CondicionesDeUso condicion: deptoRequest.getCondicionesDeUsoList()){
            CondicionesDeUso condicionGuardada = iCondicionesDeUsoRepo.getReferenceById(condicion.getIdCondicion());

            condicionGuardada.getDepartamentoList().add(deptoGuardado);

            iCondicionesDeUsoRepo.save(condicionGuardada);
        }



    }

    //METODO LISTAR TODOS LOS DEPTOS
    @Override
    public List<Departamento> buscarDepartamento(Boolean estado, String region, String comuna) {
        return deptoRepo.buscarDepartamento(estado, region, comuna);
    }

    //BUSCAR DEPTO X REGION Y COMUNA
    @Override
    public List<Departamento> findByRegionAndComuna(String region, String comuna) {
        return deptoRepo.findByRegionAndComuna(region, comuna);
    }

    //BUSCAR DEPTO POR NOMBRE
    public List<Departamento> findByNombreDepto(String nombreDepto){
        return deptoRepo.findByNombreDepto(nombreDepto);
    }

    @Override
    public Departamento findByIdDepto(Integer id) {
        return deptoRepo.findByIdDepartamento(id);
    }

    //METODO ACTUALIZAR ESTADO DEPARTAMENTO
    @Override
    public Boolean updateDeptoEstado(Boolean estado, Integer idDepartamento) {
        Integer affectedRows = deptoRepo.updateDeptoEstado(estado, idDepartamento);
        return affectedRows>0;
    }

    //METODO ACTUALIZAR DATOS DEPTO
    @Override
    public Boolean updateDatosDepto(Departamento departamento) {
        Departamento deptoGuardado = deptoRepo.findByIdDepartamento(departamento.getIdDepartamento());
        deptoGuardado.setDireccion(departamento.getDireccion());
        deptoGuardado.setNombreDepto(departamento.getNombreDepto());
        deptoGuardado.setCantidadHabitaciones(departamento.getCantidadHabitaciones());
        deptoGuardado.setCantidadBanios(departamento.getCantidadBanios());
        deptoGuardado.setRegion(departamento.getRegion());
        deptoGuardado.setComuna(departamento.getComuna());
        deptoGuardado.setDimensiones(departamento.getDimensiones());
        deptoGuardado.setCapacidadHuespedes(departamento.getCapacidadHuespedes());
        deptoGuardado.setCantidadCamas(departamento.getCantidadCamas());
        deptoGuardado.setDescripcion(departamento.getDescripcion());
        deptoGuardado.setValorDiario(departamento.getValorDiario());
        deptoRepo.save(deptoGuardado);
        return true;
    }

    //METODO ACTUALIZAR FOTOS
    @Override
    public void actualizarFotos(Departamento departamentoRequest) {

        //obtengo el id del depto para asignarselo a las nuevas fotos
        Departamento deptoGuardado = deptoRepo.findByIdDepartamento(departamentoRequest.getIdDepartamento());
        for(FotoDepto fotoRequest: departamentoRequest.getFotoDeptoList()){ //fotoDeptorequestList***
            if(fotoRequest.getAccion() == null){
                continue;
            }
            switch (fotoRequest.getAccion()){
                case AGREGAR:
                    FotoDepto fotoEntityNueva = new FotoDepto();
                    fotoEntityNueva.setDepartamento(deptoGuardado);
                    fotoEntityNueva.setTituloFotoDepto(fotoRequest.getTituloFotoDepto());
                    String fotoBase64 = fotoRequest.getFotoDeptoString().split(",")[1];
                    byte[] fotoByte = Base64.getDecoder().decode(fotoBase64);
                    try {
                        fotoEntityNueva.setFotoDepto(new SerialBlob(fotoByte));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    iFotoDeptoRepo.save(fotoEntityNueva);
                    break;
                case ELIMINAR:
                    iFotoDeptoRepo.deleteById(fotoRequest.getIdFotoDepto());
                    break;
            }

        }
    }

    //MODIFICAR ELEMENTOS INVENTARIO
    @Override
    public void actualizarInventario(Inventario inventarioNuevo){

        Inventario inventarioActual = iInventarioRepo.findByIdInventario(inventarioNuevo.getIdInventario());

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);

        for(Elemento elemento : inventarioNuevo.getElementoList()){
            if(elemento.getAccion() == null){
                continue;
            }
            switch (elemento.getAccion()){
                case AGREGAR:
                case MODIFICAR:
                    inventarioActual.setFechaInventario(strDate);
                    elemento.setInventario(inventarioActual);
                    iElementoRepo.save(elemento);
                    iInventarioRepo.save(inventarioActual);
                    break;
                case ELIMINAR:
                    inventarioActual.setFechaInventario(strDate);
                    iElementoRepo.eliminarElemento(elemento.getIdElemento());
                    iInventarioRepo.save(inventarioActual);

            }
        }
    }
}
