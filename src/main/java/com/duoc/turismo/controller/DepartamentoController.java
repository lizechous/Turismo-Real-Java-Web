package com.duoc.turismo.controller;

import com.duoc.turismo.controller.model.DepartamentoRequest;
import com.duoc.turismo.repository.model.CondicionesDeUso;
import com.duoc.turismo.repository.model.Departamento;
import com.duoc.turismo.repository.model.ServicioDepto;
import com.duoc.turismo.service.ICondicionesDeUsoService;
import com.duoc.turismo.service.IDepartamentoService;
import com.duoc.turismo.service.IServicioDeptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoController {

    @Autowired
    private IDepartamentoService deptoService;

    @Autowired
    private IServicioDeptoService servicioDeptoService;

    @Autowired
    private ICondicionesDeUsoService condicionesDeUsoService;

    //Crear depto
    @RequestMapping(value = "/crear-depto", method = RequestMethod.POST)
    public void crearDepto(@RequestBody DepartamentoRequest deptoRequest){
        deptoService.save(deptoRequest);
    }

    //Listar deptos
    @RequestMapping(value = "/listar-deptos", method = RequestMethod.GET)
    public List<Departamento> listarDeptos(){
        return deptoService.findByAllDeptos();
    }

    //Listar depto por comuna y region
    @RequestMapping(value = "/listar-deptos-por-region", method = RequestMethod.GET)
    public List<Departamento> findByRegionAndComuna(@RequestParam String region, @RequestParam String comuna) {
        return deptoService.findByRegionAndComuna(region, comuna);
    }

    //Actualizar fotos, desde Departamento
    @RequestMapping(value = "/actualizar-fotos", method = RequestMethod.POST)
    public void actualizarFotos(@RequestBody DepartamentoRequest departamentoRequest){
        deptoService.actualizarFotos(departamentoRequest);
    }

    //Eliminar depto
    @RequestMapping(value = "/eliminar-depto", method = RequestMethod.DELETE)
    public void deleteByIdDepto(@RequestParam("id_depto") Integer idDepto) {
        deptoService.deleteById(idDepto);
    }

    //Crear servicio depto, desde ServicioDepto
    @RequestMapping(value = "/crear-servicio-depto", method = RequestMethod.POST)
    public void crearServicioDepto(@RequestBody List<ServicioDepto> serviciosDeptos){
        servicioDeptoService.saveAll(serviciosDeptos);
    }

    //Actualizar servicio depto, desde Departamento
    @RequestMapping(value = "/actualizar-servicio-depto", method = RequestMethod.POST)
    public void actualizarServicioDepto(@RequestBody DepartamentoRequest departamentoRequest){
        deptoService.actualizarServicioDepto(departamentoRequest);
    }

    //Eliminar servicio, desde servicioDepto
    @RequestMapping(value = "/eliminar-servicio", method = RequestMethod.DELETE)
    public void deleteByIdServicioDepto(@RequestParam Integer idServicioDepto){
        servicioDeptoService.deleteById(idServicioDepto);
    }

    //Crear condiciones de uso, desde CondicionesDeUso
    @RequestMapping(value = "/crear-condiciones-de-uso", method = RequestMethod.POST)
    public void saveAll(@RequestBody List<CondicionesDeUso> condicionesDeUsos) {
        condicionesDeUsoService.saveAll(condicionesDeUsos);
    }


}
