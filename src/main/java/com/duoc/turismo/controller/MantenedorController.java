package com.duoc.turismo.controller;

//AQUI VAN TODOS LOS CRUD QUE SIMPLES QUE SOLO AFECTAN A UNA TABLA PARTICULAR

import com.duoc.turismo.repository.model.*;
import com.duoc.turismo.service.ICondicionesDeUsoService;
import com.duoc.turismo.service.IMantenedorService;
import com.duoc.turismo.service.IServicioDeptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/mantenedor")
public class MantenedorController {
    @Autowired
    private IServicioDeptoService servicioDeptoService;

    @Autowired
    private ICondicionesDeUsoService condicionesDeUsoService;

    @Autowired
    private IMantenedorService mantenedorService;


    //Crear servicio depto, desde ServicioDepto****
    @CrossOrigin
    @RequestMapping(value = "/crear-servicio-depto", method = RequestMethod.POST)
    public void crearServicioDepto(@RequestBody ServicioDepto servicioDepto){
        servicioDeptoService.save(servicioDepto);
    }

    //Listar servicios depto
    @CrossOrigin
    @RequestMapping(value = "/listar-servicios-depto", method = RequestMethod.GET)
    public List<ServicioDepto> findAllServiciosDepto() {
        return servicioDeptoService.findAll();
    }

    //Eliminar servicio, desde servicioDepto
    @CrossOrigin
    @RequestMapping(value = "/eliminar-servicio", method = RequestMethod.DELETE)
    public void deleteByIdServicioDepto(@RequestParam Integer idServicioDepto){
        servicioDeptoService.deleteById(idServicioDepto);
    }

    //Crear condiciones de uso, desde CondicionesDeUso****
    @CrossOrigin
    @RequestMapping(value = "/crear-condiciones-de-uso", method = RequestMethod.POST)
    public void save(@RequestBody CondicionesDeUso condicionDeUsos) {
        condicionesDeUsoService.save(condicionDeUsos);
    }

    //Listar condiciones de uso
    @CrossOrigin
    @RequestMapping(value = "/listar-condiciones", method = RequestMethod.GET)
    public List<CondicionesDeUso> findAllCondiciones() {
        return condicionesDeUsoService.listarAllCondiciones();
    }

    //Eliminar condicion de uso, desde CondicionesDeUso***
    @CrossOrigin
    @RequestMapping(value = "/eliminar-condicion-de-uso", method = RequestMethod.DELETE)
    public void deleteById(@RequestParam Integer idCondicionDeUso) {
        condicionesDeUsoService.deleteById(idCondicionDeUso);
    }

    //Cargar comunas y regiones
    @RequestMapping(value = "/cargar-regiones-comunas", method = RequestMethod.POST)
    public Boolean cargarComunasRegiones(){
        return mantenedorService.cargarRegionesComunas();
    }

    //Listar comunas
    @CrossOrigin
    @RequestMapping(value = "/listar-comunas", method = RequestMethod.GET)
    public List<Comuna> listarComunas(@RequestParam("region") String region) {return  mantenedorService.findByAllComunas(region);}

    //Listar regiones
    @CrossOrigin
    @RequestMapping(value = "/listar-regiones", method = RequestMethod.GET)
    public List<Region> listarRegiones() {return  mantenedorService.findByAllRegion();}

    @CrossOrigin
    @RequestMapping(value = "/nueva-mantencion", method = RequestMethod.POST)
    public ResponseEntity<Void> nuevaMantencion(@RequestBody Mantencion mantencion){
        try{
            mantenedorService.crearMantencion(mantencion);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/buscar-mantenciones-depto", method = RequestMethod.GET)
    public List<Mantencion> buscarMantencionesDepto(@RequestParam Integer id) {
        return mantenedorService.buscarMantencionesDepto(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/buscar-mantencion", method = RequestMethod.GET)
    public Mantencion buscarMantencioneId(@RequestParam Integer id) {
        return mantenedorService.buscarMantencionId(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/modificar-fotos-mantencion", method = RequestMethod.POST)
    public ResponseEntity<Void> modificarFotosMantencion(@RequestBody Mantencion mantencion){
        try{
            mantenedorService.modificarFotosMantencion(mantencion);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/modificar-datos-mantencion", method = RequestMethod.POST)
    public ResponseEntity<Void> modificarDatosMantencion(@RequestBody Mantencion mantencion){
        try{
            mantenedorService.modificarMantencion(mantencion);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
