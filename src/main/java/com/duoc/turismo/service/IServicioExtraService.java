package com.duoc.turismo.service;

import com.duoc.turismo.config.exceptions.ServicioExtraException;
import com.duoc.turismo.repository.model.ServicioExtra;
import com.duoc.turismo.repository.model.Tour;
import com.duoc.turismo.repository.model.Transporte;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IServicioExtraService {

    //Crear servicio tour
    public Boolean saveTour(Tour tour) throws ServicioExtraException;

    //Crear servicio transporte
    public Boolean saveTransporte(Transporte transporte) throws ServicioExtraException;

    //Listar todos los tour
    public List<Tour> listarTours() throws ServicioExtraException;


    //LISTAR TODOS LOS TRANSPORTES
    List<Transporte> listarTransportes() throws ServicioExtraException;

    //BUSCAR TOUR POR REGION Y COMUNA
    List<Tour> findByRegionAndComunaTour(String region, String comuna) throws ServicioExtraException;

    //BUSCAR TRANSPORTE POR REGION Y COMUNA
    List<Transporte> findByRegionAndComunaTransporte(String region, String comuna) throws ServicioExtraException;

    //Eliminar tour
    Boolean deleteByIdTour(Integer idTour) throws ServicioExtraException;

    //Eliminar transporte
    Boolean deleteByIdTransporte(Integer idTransporte) throws ServicioExtraException;

    //Actualizar tour
    Tour actualizarTour(Tour tour) throws ServicioExtraException;

    //Actualizar transporte
     Transporte actualizarTransporte(Transporte transporteNuevo) throws ServicioExtraException;

}
