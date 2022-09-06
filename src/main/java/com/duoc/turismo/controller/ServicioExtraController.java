package com.duoc.turismo.controller;

import com.duoc.turismo.repository.model.ServicioExtra;
import com.duoc.turismo.repository.model.Tour;
import com.duoc.turismo.repository.model.Transporte;
import com.duoc.turismo.service.IServicioExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/servicio-extra")
public class ServicioExtraController {

    @Autowired
    IServicioExtraService iServicioExtraService;

    //Crear tour
    @RequestMapping(value = "/crear-servicio-extra-tour", method = RequestMethod.POST)
    public void saveTour(@RequestBody Tour tour){
        iServicioExtraService.saveTour(tour);
    }

    //Crear transporte
    @RequestMapping(value = "/crear-servicio-extra-transporte", method = RequestMethod.POST)
    public void saveTransporte(@RequestBody Transporte transporte){
        iServicioExtraService.saveTransporte(transporte);
    }

    //Eliminar Tour
    @RequestMapping(value = "/eliminar-tour", method = RequestMethod.DELETE)
    public void deleteTour(@RequestParam Integer idTour){
        iServicioExtraService.deleteByIdTour(idTour);
    }

    //Eliminar transporte
    @RequestMapping(value = "/eliminar-transporte", method = RequestMethod.DELETE)
    public void deleteTransporte(@RequestParam Integer idTransporte){
        iServicioExtraService.deleteByIdTransporte(idTransporte);
    }

    //Listar todos tours
    @RequestMapping(value = "/listar-tours", method = RequestMethod.GET)
    public List<Tour> listarTours(){
        return iServicioExtraService.listarTours();
    }

    //Listar todos los transportes
    @RequestMapping(value = "/listar-transportes", method = RequestMethod.GET)
    public List<Transporte> listarTransportes(){
        return iServicioExtraService.listarTransportes();
    }

    //Buscar transporte por region y comuna
    @RequestMapping(value = "/listar-transporte-region-comuna", method = RequestMethod.GET)
    public List<Transporte> findByRegionAndComunaTransporte(String region, String comuna){
       return iServicioExtraService.findByRegionAndComunaTransporte(region, comuna);
    }

    //Buscar tour por region y comuna
    @RequestMapping(value = "/listar-tour-region-comuna", method = RequestMethod.GET)
    public List<Tour> findByRegionAndComunaTour(String region, String comuna){
        return iServicioExtraService.findByRegionAndComunaTour(region, comuna);
    }

    //Actualizar tour
    @RequestMapping(value = "/actualizar-tour", method = RequestMethod.POST)
    public Tour actualizarTour(@RequestBody Tour tourNuevo){
            return iServicioExtraService.actualizarTour(tourNuevo);
    }

    //Actualizar transporte
    @RequestMapping(value = "/actualizar-transporte", method = RequestMethod.POST)
    public Transporte actualizarTransporte(@RequestBody Transporte transporteNuevo){
        return iServicioExtraService.actualizarTransporte(transporteNuevo);
    }

}
