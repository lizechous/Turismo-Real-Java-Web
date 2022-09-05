package com.duoc.turismo.controller;

//AQUI VAN TODOS LOS CRUD QUE SIMPLES QUE SOLO AFECTAN A UNA TABLA PARTICULAR

import com.duoc.turismo.repository.model.CondicionesDeUso;
import com.duoc.turismo.repository.model.ServicioDepto;
import com.duoc.turismo.service.ICondicionesDeUsoService;
import com.duoc.turismo.service.IServicioDeptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/mantenedor")
public class MantenedorController {
    @Autowired
    private IServicioDeptoService servicioDeptoService;

    @Autowired
    private ICondicionesDeUsoService condicionesDeUsoService;


    //Crear servicio depto, desde ServicioDepto****
    @RequestMapping(value = "/crear-servicio-depto", method = RequestMethod.POST)
    public void crearServicioDepto(@RequestBody List<ServicioDepto> serviciosDeptos){
        servicioDeptoService.saveAll(serviciosDeptos);
    }

    //Listar servicios depto
    @RequestMapping(value = "/listar-servicios-depto", method = RequestMethod.GET)
    public List<ServicioDepto> findAllServiciosDepto() {
        return servicioDeptoService.findAll();
    }

    //Eliminar servicio, desde servicioDepto
    @RequestMapping(value = "/eliminar-servicio", method = RequestMethod.DELETE)
    public void deleteByIdServicioDepto(@RequestParam Integer idServicioDepto){
        servicioDeptoService.deleteById(idServicioDepto);
    }

    //Crear condiciones de uso, desde CondicionesDeUso****
    @RequestMapping(value = "/crear-condiciones-de-uso", method = RequestMethod.POST)
    public void saveAll(@RequestBody List<CondicionesDeUso> condicionesDeUsos) {
        condicionesDeUsoService.saveAll(condicionesDeUsos);
    }

    //Listar condiciones de uso
    @RequestMapping(value = "/listar-condiciones", method = RequestMethod.GET)
    public List<CondicionesDeUso> findAllCondiciones() {
        return condicionesDeUsoService.listarAllCondiciones();
    }

    //Eliminar condicion de uso, desde CondicionesDeUso***
    @RequestMapping(value = "/eliminar-condicion-de-uso", method = RequestMethod.DELETE)
    public void deleteById(@RequestParam Integer idCondicionDeUso) {
        condicionesDeUsoService.deleteById(idCondicionDeUso);
    }
}
