package com.duoc.turismo.service;

import com.duoc.turismo.controller.model.DepartamentoRequest;
import com.duoc.turismo.controller.model.FotoDeptoRequest;
import com.duoc.turismo.repository.*;
import com.duoc.turismo.repository.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
        depto.setEstado(deptoRequest.getEstado());
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
    public List<Departamento> findByAllDeptos() {
        return deptoRepo.findAll();
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

    //METODO ACTUALIZAR ESTADO DEPARTAMENTO
    @Override
    public Boolean updateDeptoEstado(String estado, Integer idDepartamento) {
        Integer affectedRows = deptoRepo.updateDeptoEstado(estado, idDepartamento);
        return affectedRows>0;
    }

    //METODO ACTUALIZAR DATOS DEPTO
    @Override
    public Boolean updateDatosDepto(Integer valorDiario, Integer cantidadCamas, Integer capacidadHuespedes, Integer idDepto, String descripcion) {
        Integer affectedRows = deptoRepo.updateDatosDepto(valorDiario, cantidadCamas, capacidadHuespedes, idDepto, descripcion);
        return affectedRows>0;
    }

    //METODO ACTUALIZAR FOTOS
    @Override
    public void actualizarFotos(DepartamentoRequest departamentoRequest) {

        //obtengo el id del depto para asignarselo a las nuevas fotos
        Departamento deptoGuardado = deptoRepo.getReferenceById(departamentoRequest.getIdDepto());
        for(FotoDeptoRequest fotoRequest: departamentoRequest.getFotoDeptoList()){ //fotoDeptorequestList***

            switch (fotoRequest.getAccionFoto()){
                case AGREGAR:
                    FotoDepto fotoEntityNueva = new FotoDepto();
                    fotoEntityNueva.setDepartamento(deptoGuardado);
                    fotoEntityNueva.setTituloFotoDepto(fotoRequest.getTituloFotoDepto());
                    byte[] fotoByte = Base64.getDecoder().decode(fotoRequest.getFotoDepto());
                    try {
                        fotoEntityNueva.setFotoDepto(new SerialBlob(fotoByte));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    iFotoDeptoRepo.save(fotoEntityNueva);
                    break;
                case ELIMINAR:
                    iFotoDeptoRepo.deleteById(fotoRequest.getIdFoto());
                    break;
                case MODIFICAR:
                    FotoDepto fotoModificar = iFotoDeptoRepo.getReferenceById(fotoRequest.getIdFoto());
                    fotoModificar.setTituloFotoDepto(fotoRequest.getTituloFotoDepto());
                    byte[] fotoByteModificada = Base64.getDecoder().decode(fotoRequest.getFotoDepto());
                    try {
                        fotoModificar.setFotoDepto(new SerialBlob(fotoByteModificada));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    iFotoDeptoRepo.save(fotoModificar);
                    break;
            }

        }
    }

    //MODIFICAR SERVICIO DEPTO
    @Override
    public void actualizarServicioDepto(DepartamentoRequest departamentoRequest) {
        Departamento deptoActual = deptoRepo.getReferenceById(departamentoRequest.getIdDepto());
        //Verifico cuales son los servicios a desasignar
        for(ServicioDepto servicioActual : deptoActual.getServicioDeptoList()){
            Boolean existe = false; //por defecto no existe
            for(ServicioDepto servicioNuevo : departamentoRequest.getServicioDeptoList()){
                if(servicioActual.getIdServicioDepto()== servicioNuevo.getIdServicioDepto()){
                    existe=true;
                    break;
                }
            }
            if(existe == false) {
                //ELIMINA EL DEPTO ASOCIADO AL SERVICIO
                ServicioDepto servicioDesasignar = iServicioDeptoRepo.getReferenceById(servicioActual.getIdServicioDepto());
                servicioDesasignar.getDepartamentoList().remove(deptoActual);
                iServicioDeptoRepo.save(servicioDesasignar);
            }
        }

        //Verifico cuales son los servicios a asignar
        for(ServicioDepto servicioNuevo: departamentoRequest.getServicioDeptoList()){
            Boolean existe = false;
            for(ServicioDepto servicioActual: deptoActual.getServicioDeptoList()) {
                if(servicioNuevo.getIdServicioDepto() == servicioActual.getIdServicioDepto()){
                    existe = true;
                    break;
                }
            }
            if(existe == false) {
                ServicioDepto servicioAsignar = iServicioDeptoRepo.getReferenceById(servicioNuevo.getIdServicioDepto());
                servicioAsignar.getDepartamentoList().add(deptoActual);
                iServicioDeptoRepo.save(servicioAsignar);
            }
        }
    }

    //MODIFICAR CONDICIONES DE USO
    @Override
    public void actualizarCondiciones(DepartamentoRequest departamentoRequest){
        Departamento deptoActual = deptoRepo.getReferenceById(departamentoRequest.getIdDepto());
        //Verifico cuales son las condiciones a desasignar
        for(CondicionesDeUso condicionActual : deptoActual.getCondicionesDeUsoList()){
            Boolean existe = false; //por defecto no existe
            for(CondicionesDeUso condicionNueva : departamentoRequest.getCondicionesDeUsoList()){
                if(condicionActual.getIdCondicion()== condicionNueva.getIdCondicion()){
                    existe=true;
                    break;
                }
            }
            if(existe == false) {
                //ELIMINA EL DEPTO ASOCIADO A LA CONDICION
                CondicionesDeUso condicionDesasignar = iCondicionesDeUsoRepo.getReferenceById(condicionActual.getIdCondicion());
                condicionDesasignar.getDepartamentoList().remove(deptoActual);
                iCondicionesDeUsoRepo.save(condicionDesasignar);
            }
        }

        //Verifico cuales son las condiciones a asignar
        for(CondicionesDeUso condicionNueva: departamentoRequest.getCondicionesDeUsoList()){
            Boolean existe = false;
            for(CondicionesDeUso condicionActual: deptoActual.getCondicionesDeUsoList()) {
                if(condicionNueva.getIdCondicion() == condicionActual.getIdCondicion()){
                    existe = true;
                    break;
                }
            }
            if(existe == false) {
                CondicionesDeUso condicionAsignar = iCondicionesDeUsoRepo.getReferenceById(condicionNueva.getIdCondicion());
                condicionAsignar.getDepartamentoList().add(deptoActual);
                iCondicionesDeUsoRepo.save(condicionAsignar);
            }
        }
    }

    //MODIFICAR ELEMENTOS INVENTARIO
    @Override
    public void actualizarInventario(Inventario inventarioNuevo){

        Inventario inventarioActual = iInventarioRepo.getReferenceById(inventarioNuevo.getIdInventario());

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);

        for(Elemento elemento : inventarioNuevo.getElementoList()){
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

    //METODO ELIMINAR DEPTO
    @Override
    public void deleteById(Integer idDepto) {
        //obtengo el depto por id
        Departamento depto = deptoRepo.getReferenceById(idDepto);
        deptoRepo.deleteById(depto.getIdDepartamento());
    }
}
