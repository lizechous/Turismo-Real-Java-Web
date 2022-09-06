package com.duoc.turismo.controller;

import com.duoc.turismo.config.exceptions.ServicioExtraException;
import com.duoc.turismo.repository.model.ServicioExtra;
import com.duoc.turismo.repository.model.Tour;
import com.duoc.turismo.repository.model.Transporte;
import com.duoc.turismo.service.IServicioExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Boolean> saveTour(@RequestBody Tour tour) throws ServicioExtraException {
        try{
            return new ResponseEntity<>(iServicioExtraService.saveTour(tour), HttpStatus.ACCEPTED);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Crear transporte
    @RequestMapping(value = "/crear-servicio-extra-transporte", method = RequestMethod.POST)
    public ResponseEntity<Boolean> saveTransporte(@RequestBody Transporte transporte){
        try {
            return new ResponseEntity<>(iServicioExtraService.saveTransporte(transporte), HttpStatus.ACCEPTED);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Eliminar Tour
    @RequestMapping(value = "/eliminar-tour", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteTour(@RequestParam Integer idTour){
        try{
            return new ResponseEntity<>(iServicioExtraService.deleteByIdTour(idTour), HttpStatus.OK);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Eliminar transporte
    @RequestMapping(value = "/eliminar-transporte", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteTransporte(@RequestParam Integer idTransporte){
        try{
            return new ResponseEntity<>(iServicioExtraService.deleteByIdTransporte(idTransporte), HttpStatus.OK);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Listar todos tours
    @RequestMapping(value = "/listar-tours", method = RequestMethod.GET)
    public ResponseEntity<List> listarTours(){
        try{
            return new ResponseEntity<>(iServicioExtraService.listarTours(), HttpStatus.FOUND);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Listar todos los transportes
    @RequestMapping(value = "/listar-transportes", method = RequestMethod.GET)
    public ResponseEntity<List> listarTransportes(){
        try{
            return new ResponseEntity<>(iServicioExtraService.listarTransportes(), HttpStatus.FOUND);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Buscar transporte por region y comuna
    @RequestMapping(value = "/listar-transporte-region-comuna", method = RequestMethod.GET)
    public ResponseEntity<List> findByRegionAndComunaTransporte(String region, String comuna){
       try{
           return new ResponseEntity<>(iServicioExtraService.findByRegionAndComunaTransporte(region, comuna), HttpStatus.FOUND);
       }catch (ServicioExtraException e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    //Buscar tour por region y comuna
    @RequestMapping(value = "/listar-tour-region-comuna", method = RequestMethod.GET)
    public ResponseEntity<List> findByRegionAndComunaTour(String region, String comuna){
        try{
            return new ResponseEntity<>(iServicioExtraService.findByRegionAndComunaTour(region, comuna), HttpStatus.FOUND);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Actualizar tour
    @RequestMapping(value = "/actualizar-tour", method = RequestMethod.POST)
    public ResponseEntity<Tour> actualizarTour(@RequestBody Tour tourNuevo){
            try{
                return new ResponseEntity<>(iServicioExtraService.actualizarTour(tourNuevo), HttpStatus.ACCEPTED);
            }catch (ServicioExtraException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }

    //Actualizar transporte
    @RequestMapping(value = "/actualizar-transporte", method = RequestMethod.POST)
    public ResponseEntity<Transporte> actualizarTransporte(@RequestBody Transporte transporteNuevo){
        try{
            return new ResponseEntity<>(iServicioExtraService.actualizarTransporte(transporteNuevo), HttpStatus.ACCEPTED);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
