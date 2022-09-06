package com.duoc.turismo.service;

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
    public void saveTour(Tour tour) {
        iTourRepo.save(tour);
    }

    //CREAR TRANSPORTE
    @Override
    public void saveTransporte(Transporte transporte) {
        iTransporteRepo.save(transporte);
    }

    @Override
    //LISTAR TODOS LOS TOUR
    public List<Tour> listarTours(){
        return iTourRepo.findAll();
    }

    @Override
    //LISTAR TODOS LOS TRANSPORTES
    public List<Transporte> listarTransportes(){
        return iTransporteRepo.findAll();
    }

    @Override
    public List<Tour> findByRegionAndComunaTour(String region, String comuna) {
        return iTourRepo.findByRegionAndComuna(region,comuna);
    }

    @Override
    public List<Transporte> findByRegionAndComunaTransporte(String region, String comuna) {
        return iTransporteRepo.findByRegionAndComuna(region, comuna);
    }

    //ELIMINAR TOUR
    @Override
    public void deleteByIdTour(Integer idTour) {
        iTourRepo.deleteById(idTour);
    }

    //ELIMINAR TRANSPORTE
    @Override
    public void deleteByIdTransporte(Integer idTransporte) {
        iTransporteRepo.deleteById(idTransporte);
    }

    //Actualizar tour
    @Override
    public Tour actualizarTour(Tour tourNuevo) {
        Tour tourActual = iTourRepo.getReferenceById(tourNuevo.getIdServicioExtra());
        tourActual.setDescripcionTour(tourNuevo.getDescripcionTour());
        tourActual.setTituloTour(tourNuevo.getTituloTour());
        tourActual.setCantidadPersonasMax(tourNuevo.getCantidadPersonasMax());
        tourActual.setRegion(tourNuevo.getRegion());
        tourActual.setComuna(tourNuevo.getComuna());
        tourActual.setPersonaACargo(tourNuevo.getPersonaACargo());
       return iTourRepo.save(tourActual);
    }

    //Actualizar transporte
    @Override
    public Transporte actualizarTransporte(Transporte transporteNuevo) {
        //Me traigo el objeto de la bds que coincida con el objeto del request y lo guardo en la variable
        Transporte transporteActual = iTransporteRepo.getReferenceById(transporteNuevo.getIdServicioExtra());
        //le seteo los datos que tiene el objeto request
        transporteActual.setRegion(transporteNuevo.getRegion());
        transporteActual.setComuna(transporteNuevo.getComuna());
        transporteActual.setMarca(transporteNuevo.getMarca());
        transporteActual.setModelo(transporteNuevo.getModelo());
        transporteActual.setCapacidadPasajeros(transporteNuevo.getCapacidadPasajeros());
        transporteActual.setPatente(transporteNuevo.getPatente());
        //guardo el objeto de la bds modificado, de nuevo en la bds
        return iTransporteRepo.save(transporteActual);
    }
}
