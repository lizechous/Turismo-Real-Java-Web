package com.duoc.turismo.service;

import com.duoc.turismo.repository.model.ServicioExtra;
import com.duoc.turismo.repository.model.Tour;
import com.duoc.turismo.repository.model.Transporte;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IServicioExtraService {

    //Crear servicio tour
    public void saveTour(Tour tour);

    //Crear servicio transporte
    public void saveTransporte(Transporte transporte);

    //Listar todos los tour
    public List<Tour> listarTours();


    //LISTAR TODOS LOS TRANSPORTES
    List<Transporte> listarTransportes();

    //BUSCAR TOUR POR REGION Y COMUNA
    List<Tour> findByRegionAndComunaTour(String region, String comuna);

    //BUSCAR TRANSPORTE POR REGION Y COMUNA
    List<Transporte> findByRegionAndComunaTransporte(String region, String comuna);

    //Eliminar tour
    void deleteByIdTour(Integer idTour);

    //Eliminar transporte
    void deleteByIdTransporte(Integer idTransporte);

    //Actualizar tour
    Tour actualizarTour(Tour tour);

    //Actualizar transporte
     Transporte actualizarTransporte(Transporte transporteNuevo);

}
