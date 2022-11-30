package com.duoc.turismo.service;

import com.duoc.turismo.config.exceptions.ServicioExtraException;
import com.duoc.turismo.repository.model.SolicitudServicioExtra;
import com.duoc.turismo.repository.model.Tour;
import com.duoc.turismo.repository.model.Transporte;

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
    List<Transporte> findByRegionAndComunaTransporte(String region, String comuna, Integer personas) throws ServicioExtraException;

    //Eliminar tour
    Boolean cambiarEstadoTour(Integer idTour, Boolean estado) throws ServicioExtraException;

    //Eliminar transporte
    Boolean cambiarEstadoTransporte(Integer idTransporte, Boolean estado) throws ServicioExtraException;

    //Actualizar tour
    Tour actualizarTour(Tour tour) throws ServicioExtraException;

    //Actualizar transporte
     Transporte actualizarTransporte(Transporte transporteNuevo) throws ServicioExtraException;

     List<String> getRegionesTour() throws ServicioExtraException;

    List<String> getRegionesTransporte() throws ServicioExtraException;

    List<String> getComunasTour(String region) throws ServicioExtraException;

    List<String> getComunasTransporte(String region) throws ServicioExtraException;

    Tour buscarTourPorId(Integer id) throws ServicioExtraException;

    Transporte buscarTransportePorId(Integer id) throws ServicioExtraException;

    void actualizarFotos(Tour tour) throws ServicioExtraException;

    List<SolicitudServicioExtra> buscarSolicitudes();

    List<SolicitudServicioExtra> buscarSolicitudesCliente(Integer idCliente);

    void planificarServicio(SolicitudServicioExtra solicitud);

    SolicitudServicioExtra buscarSolicitud(Integer id);

}
