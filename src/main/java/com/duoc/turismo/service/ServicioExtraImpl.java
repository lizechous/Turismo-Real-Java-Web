package com.duoc.turismo.service;

import com.duoc.turismo.config.exceptions.ServicioExtraException;
import com.duoc.turismo.repository.ITourRepo;
import com.duoc.turismo.repository.ITransporteRepo;
import com.duoc.turismo.repository.model.Tour;
import com.duoc.turismo.repository.model.Transporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioExtraImpl implements IServicioExtraService {

    @Autowired
    ITourRepo iTourRepo;

    @Autowired
    ITransporteRepo iTransporteRepo;

    //CREAR TOUR
    @Override
    public Boolean saveTour(Tour tour) throws ServicioExtraException {
        try{
            iTourRepo.save(tour);
            return true;
        }catch (Exception e){
            throw new ServicioExtraException("Error al crear servicio tour");
        }
    }

    //CREAR TRANSPORTE
    @Override
    public Boolean saveTransporte(Transporte transporte) throws ServicioExtraException {
        try {
            iTransporteRepo.save(transporte);
            return true;
        }catch (Exception e){
            throw new ServicioExtraException("Error al crear servicio transporte");
        }
    }

    @Override
    //LISTAR TODOS LOS TOUR
    public List<Tour> listarTours() throws ServicioExtraException {

        try{
            return iTourRepo.findAll();
        }catch (Exception e){
            throw new ServicioExtraException("Error al listar los tour");
        }
    }

    @Override
    //LISTAR TODOS LOS TRANSPORTES
    public List<Transporte> listarTransportes() throws ServicioExtraException {

        try {
            return iTransporteRepo.findAll();
        }catch (Exception e){
            throw new ServicioExtraException("Error al listar transportes");
        }
    }

    @Override
    public List<Tour> findByRegionAndComunaTour(String region, String comuna) throws ServicioExtraException {
        try{
            return iTourRepo.findByRegionAndComuna(region,comuna);
        }catch (Exception e){
            throw new ServicioExtraException("Error al buscar tour");
        }
    }

    @Override
    public List<Transporte> findByRegionAndComunaTransporte(String region, String comuna) throws ServicioExtraException {
        try{
            return iTransporteRepo.findByRegionAndComuna(region, comuna);
        }catch (Exception e){
            throw new ServicioExtraException("Error al buscar transporte");
        }
    }

    //ELIMINAR TOUR
    @Override
    public Boolean deleteByIdTour(Integer idTour) throws ServicioExtraException {

        try{
            iTourRepo.deleteById(idTour);
            return true;
        }catch (Exception e){
            throw new ServicioExtraException("Error al eliminar tour");
        }
    }

    //ELIMINAR TRANSPORTE
    @Override
    public Boolean deleteByIdTransporte(Integer idTransporte) throws ServicioExtraException {

        try{
            iTransporteRepo.deleteById(idTransporte);
            return true;
        }catch (Exception e){
            throw new ServicioExtraException("Error al eliminar transporte");
        }
    }

    //Actualizar tour
    @Override
    public Tour actualizarTour(Tour tourNuevo) throws ServicioExtraException {
        Tour tourActual = iTourRepo.getReferenceById(tourNuevo.getIdServicioExtra());
        tourActual.setDescripcionTour(tourNuevo.getDescripcionTour());
        tourActual.setTituloTour(tourNuevo.getTituloTour());
        tourActual.setCantidadPersonasMax(tourNuevo.getCantidadPersonasMax());
        tourActual.setRegion(tourNuevo.getRegion());
        tourActual.setComuna(tourNuevo.getComuna());
        tourActual.setPersonaACargo(tourNuevo.getPersonaACargo());
      try{
          return iTourRepo.save(tourActual);
      }catch (Exception e){
          throw new ServicioExtraException("Error al actualizar tour");
      }
    }

    //Actualizar transporte
    @Override
    public Transporte actualizarTransporte(Transporte transporteNuevo) throws ServicioExtraException {
        //Me traigo el objeto de la bds que coincida con el objeto del request y lo guardo en la variable
        Transporte transporteActual = iTransporteRepo.getReferenceById(transporteNuevo.getIdServicioExtra());
        //le seteo los datos que tiene el objeto request
        transporteActual.setPersonaACargo(transporteNuevo.getPersonaACargo());
        transporteActual.setRegion(transporteNuevo.getRegion());
        transporteActual.setComuna(transporteNuevo.getComuna());
        transporteActual.setMarca(transporteNuevo.getMarca());
        transporteActual.setModelo(transporteNuevo.getModelo());
        transporteActual.setCapacidadPasajeros(transporteNuevo.getCapacidadPasajeros());
        transporteActual.setPatente(transporteNuevo.getPatente());
        //guardo el objeto de la bds modificado, de nuevo en la bds
        try{
            return iTransporteRepo.save(transporteActual);
        }catch (Exception e){
            throw new ServicioExtraException("Error al actualizar transporte");
        }
    }
}
