package com.duoc.turismo.controller;

import com.duoc.turismo.config.exceptions.ServicioExtraException;
import com.duoc.turismo.repository.model.*;
import com.duoc.turismo.service.IServicioExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/servicio-extra")
public class ServicioExtraController {

    @Autowired
    IServicioExtraService iServicioExtraService;

    //Crear tour
    @CrossOrigin
    @RequestMapping(value = "/crear-servicio-extra-tour", method = RequestMethod.POST)
    public ResponseEntity<Boolean> saveTour(@RequestBody Tour tour) throws ServicioExtraException {
        try{
            return new ResponseEntity<>(iServicioExtraService.saveTour(tour), HttpStatus.OK);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Crear transporte
    @CrossOrigin
    @RequestMapping(value = "/crear-servicio-extra-transporte", method = RequestMethod.POST)
    public ResponseEntity<Boolean> saveTransporte(@RequestBody Transporte transporte){
        try {
            return new ResponseEntity<>(iServicioExtraService.saveTransporte(transporte), HttpStatus.OK);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Eliminar Tour
    @CrossOrigin
    @RequestMapping(value = "/estado-tour", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> cambiarEstadoTour(@RequestParam Integer idTour, @RequestParam Boolean estado){
        try{
            return new ResponseEntity<>(iServicioExtraService.cambiarEstadoTour(idTour, estado), HttpStatus.OK);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Eliminar transporte
    @CrossOrigin
    @RequestMapping(value = "/estado-transporte", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> desactivarTransporte(@RequestParam Integer idTransporte, @RequestParam Boolean estado){
        try{
            return new ResponseEntity<>(iServicioExtraService.cambiarEstadoTransporte(idTransporte, estado), HttpStatus.OK);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Listar todos tours
    @CrossOrigin
    @RequestMapping(value = "/listar-tours", method = RequestMethod.GET)
    public ResponseEntity<List> listarTours(){
        try{
            return new ResponseEntity<>(iServicioExtraService.listarTours(), HttpStatus.OK);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Listar todos los transportes
    @CrossOrigin
    @RequestMapping(value = "/listar-transportes", method = RequestMethod.GET)
    public ResponseEntity<List> listarTransportes(){
        try{
            return new ResponseEntity<>(iServicioExtraService.listarTransportes(), HttpStatus.OK);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Buscar transporte por region y comuna
    @CrossOrigin
    @RequestMapping(value = "/listar-transporte-region-comuna", method = RequestMethod.GET)
    public ResponseEntity<List> findByRegionAndComunaTransporte(String region, String comuna, @RequestParam(required = false) Integer personas){
       try{
           return new ResponseEntity<>(iServicioExtraService.findByRegionAndComunaTransporte(region, comuna, personas), HttpStatus.OK);
       }catch (ServicioExtraException e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    //Buscar tour por region y comuna
    @CrossOrigin
    @RequestMapping(value = "/listar-tour-region-comuna", method = RequestMethod.GET)
    public ResponseEntity<List> findByRegionAndComunaTour(String region,
                                                          String comuna){
        try{
            return new ResponseEntity<>(iServicioExtraService.findByRegionAndComunaTour(region.replace("%20", " "), comuna.replace("%20", " ")), HttpStatus.OK);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Actualizar tour
    @CrossOrigin
    @RequestMapping(value = "/actualizar-tour", method = RequestMethod.POST)
    public ResponseEntity<Tour> actualizarTour(@RequestBody Tour tourNuevo){
            try{
                return new ResponseEntity<>(iServicioExtraService.actualizarTour(tourNuevo), HttpStatus.OK);
            }catch (ServicioExtraException e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    //Actualizar transporte
    @CrossOrigin
    @RequestMapping(value = "/actualizar-transporte", method = RequestMethod.POST)
    public ResponseEntity<Transporte> actualizarTransporte(@RequestBody Transporte transporteNuevo){
        try{
            return new ResponseEntity<>(iServicioExtraService.actualizarTransporte(transporteNuevo), HttpStatus.OK);
        }catch (ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/listar-regiones-tour", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getRegionesTour(){
        try {
            return new ResponseEntity<>(iServicioExtraService.getRegionesTour(), HttpStatus.OK);
        } catch (ServicioExtraException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/listar-comunas-tour", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getComunasTour(@RequestParam String region){
        try {
            return new ResponseEntity<>(iServicioExtraService.getComunasTour(region.replace("%20", " ")), HttpStatus.OK);
        } catch (ServicioExtraException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/listar-regiones-transporte", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getRegionesTransporte(){
        try {
            return new ResponseEntity<>(iServicioExtraService.getRegionesTransporte(), HttpStatus.OK);
        } catch (ServicioExtraException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/listar-comunas-transporte", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getComunasTransporte(@RequestParam String region){
        try {
            return new ResponseEntity<>(iServicioExtraService.getComunasTransporte(region.replace("%20", " ")), HttpStatus.OK);
        } catch (ServicioExtraException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/buscar-tour-id", method = RequestMethod.GET)
    public ResponseEntity<Tour> buscarTourPorId(@RequestParam Integer id){
        try{
            return new ResponseEntity<>(iServicioExtraService.buscarTourPorId(id), HttpStatus.OK);
        } catch(ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/buscar-transporte-id", method = RequestMethod.GET)
    public ResponseEntity<Transporte> buscarTransportePorId(@RequestParam Integer id){
        try{
            return new ResponseEntity<>(iServicioExtraService.buscarTransportePorId(id), HttpStatus.OK);
        } catch(ServicioExtraException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/actualizar-fotos", method = RequestMethod.POST)
    public void actualizarFotos(@RequestBody Tour tourRequest) throws ServicioExtraException {
        iServicioExtraService.actualizarFotos(tourRequest);
    }

    @CrossOrigin
    @RequestMapping(value = "/buscar-solicitudes", method = RequestMethod.GET)
    public ResponseEntity<List<SolicitudServicioExtra>> buscarSolicitudes(){
        try{
            return new ResponseEntity<>(iServicioExtraService.buscarSolicitudes(), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/buscar-solicitudes-cliente", method = RequestMethod.GET)
    public ResponseEntity<List<SolicitudServicioExtra>> buscarSolicitudesCliente(@RequestParam Integer id){
        try{
            return new ResponseEntity<>(iServicioExtraService.buscarSolicitudesCliente(id), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/buscar-solicitud", method = RequestMethod.GET)
    public ResponseEntity<SolicitudServicioExtra> buscarSolicitud(@RequestParam Integer id){
        try{
            return new ResponseEntity<>(iServicioExtraService.buscarSolicitud(id), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/planificar-servicio", method = RequestMethod.POST)
    public void planificarServicio(@RequestBody SolicitudServicioExtra request) throws ServicioExtraException {
        iServicioExtraService.planificarServicio(request);
    }

}
