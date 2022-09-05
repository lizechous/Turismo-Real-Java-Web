package com.duoc.turismo.controller;

import com.duoc.turismo.controller.model.DepartamentoRequest;
import com.duoc.turismo.repository.IInventarioRepo;
import com.duoc.turismo.repository.model.CondicionesDeUso;
import com.duoc.turismo.repository.model.Departamento;
import com.duoc.turismo.repository.model.Inventario;
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

    @Autowired
    private IInventarioRepo inventarioRepo;

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

    //Buscar deptos por comuna y region
    @RequestMapping(value = "/listar-deptos-por-region-comuna", method = RequestMethod.GET)
    public List<Departamento> findByRegionAndComuna(@RequestParam String region, @RequestParam String comuna) {
        return deptoService.findByRegionAndComuna(region, comuna);
    }

    //Buscar depto por nombre
    @RequestMapping(value = "/buscar-depto-por-nombre", method = RequestMethod.GET)
    public List<Departamento> findByNombreDepto(String nombreDepto){
        return deptoService.findByNombreDepto(nombreDepto);
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

    //Actualizar servicio depto, desde Departamento
    @RequestMapping(value = "/actualizar-servicio-depto", method = RequestMethod.POST)
    public void actualizarServicioDepto(@RequestBody DepartamentoRequest departamentoRequest){
        deptoService.actualizarServicioDepto(departamentoRequest);
    }

    //Actualizar condiciones desde Departamento
    @RequestMapping(value = "/actualizar-condiciones-depto", method = RequestMethod.POST)
    public void actualizarCondiciones(@RequestBody DepartamentoRequest departamentoRequest) {
        deptoService.actualizarCondiciones(departamentoRequest);
    }

    //Actualizar inventario
    @RequestMapping(value = "/actualizar-inventario", method = RequestMethod.POST)
    public void actualizarInventario(@RequestBody Inventario inventarioNuevo){
        deptoService.actualizarInventario(inventarioNuevo);
    }
}
