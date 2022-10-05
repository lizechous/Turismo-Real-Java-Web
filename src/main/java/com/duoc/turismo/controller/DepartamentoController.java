package com.duoc.turismo.controller;

import com.duoc.turismo.controller.model.DepartamentoRequest;
import com.duoc.turismo.repository.IInventarioRepo;
import com.duoc.turismo.repository.model.CondicionesDeUso;
import com.duoc.turismo.repository.model.Departamento;
import com.duoc.turismo.repository.model.Inventario;
import com.duoc.turismo.repository.model.ServicioDepto;
import com.duoc.turismo.service.ICondicionesDeUsoService;
import com.duoc.turismo.service.IDepartamentoService;
import com.duoc.turismo.service.IInventarioService;
import com.duoc.turismo.service.IServicioDeptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    private IInventarioService inventarioService;

    //Crear depto
    @CrossOrigin
    @RequestMapping(value = "/crear-depto", method = RequestMethod.POST)
    public void crearDepto(@RequestBody DepartamentoRequest deptoRequest){
        deptoService.save(deptoRequest);
    }

    //Listar deptos
    @CrossOrigin
    @RequestMapping(value = "/listar-deptos", method = RequestMethod.GET)
    public List<Departamento> listarDeptos(@RequestParam("estado") Boolean estado,
                                           @RequestParam(required = false) String region,
                                           @RequestParam(required = false) String comuna){
        return deptoService.buscarDepartamento(estado, region, comuna);
    }

    //Buscar deptos por comuna y region
    @CrossOrigin
    @RequestMapping(value = "/listar-deptos-por-region-comuna", method = RequestMethod.GET)
    public List<Departamento> findByRegionAndComuna(@RequestParam String region, @RequestParam String comuna) {
        return deptoService.findByRegionAndComuna(region, comuna);
    }

    //Buscar depto por nombre
    @CrossOrigin
    @RequestMapping(value = "/buscar-depto-por-nombre", method = RequestMethod.GET)
    public List<Departamento> findByNombreDepto(String nombreDepto){
        return deptoService.findByNombreDepto(nombreDepto);
    }

    @CrossOrigin
    @RequestMapping(value = "/buscar-depto-por-id", method = RequestMethod.GET)
    public Departamento findById(@RequestParam Integer id){
        return deptoService.findByIdDepto(id);
    }

    //Actualizar datos depto
    @CrossOrigin
    @RequestMapping(value = "/actualizar-datos-depto", method = RequestMethod.POST)
    public void updateDatosDepto(@RequestBody Departamento departamento){
         deptoService.updateDatosDepto(departamento);
    }

    //Actualizar estado depto
    @CrossOrigin
    @RequestMapping(value = "/actualizar-estado-depto", method = RequestMethod.POST)
    Boolean updateDeptoEstado(@RequestParam Boolean estado, @RequestParam Integer idDepartamento){
        return deptoService.updateDeptoEstado(estado, idDepartamento);
    }


    //Actualizar fotos, desde Departamento
    @CrossOrigin
    @RequestMapping(value = "/actualizar-fotos", method = RequestMethod.POST)
    public void actualizarFotos(@RequestBody Departamento departamentoRequest){
        deptoService.actualizarFotos(departamentoRequest);
    }

    //Actualizar inventario
    @CrossOrigin
    @RequestMapping(value = "/actualizar-inventario", method = RequestMethod.POST)
    public void actualizarInventario(@RequestBody Inventario inventarioNuevo){
        deptoService.actualizarInventario(inventarioNuevo);
    }

    //Actualizar servicio depto, desde Departamento
    @CrossOrigin
    @RequestMapping(value = "/actualizar-servicio-depto", method = RequestMethod.POST)
    public void actualizarServicioDepto(@RequestBody Departamento departamentoRequest){
        deptoService.actualizarServicioDepto(departamentoRequest);
    }

    //Actualizar condiciones desde Departamento
    @CrossOrigin
    @RequestMapping(value = "/actualizar-condiciones-depto", method = RequestMethod.POST)
    public void actualizarCondiciones(@RequestBody Departamento departamentoRequest) {
        deptoService.actualizarCondiciones(departamentoRequest);
    }

    @CrossOrigin
    @RequestMapping(value = "/comunas-depto", method = RequestMethod.GET)
    public List<String> getComunasDepto(){
        return deptoService.getComunasDepto();
    }

    @CrossOrigin
    @RequestMapping(value = "/deptos-disponibles", method = RequestMethod.GET)
    public List<Departamento> getDeptosDisponibles(@RequestParam("fecha_llegada") String fechaLlegada,
                                                   @RequestParam("fecha_fin") String fechaFin,
                                                   @RequestParam(required = false) String comuna,
                                                   @RequestParam(required = false, value = "valor_maximo") Integer valorMaximo){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaLlegadaDate = null;
        Date fechaFinDate = null;
        try {
            fechaLlegadaDate = formatter.parse(fechaLlegada);
            fechaFinDate = formatter.parse(fechaFin);
        } catch (ParseException e) {
            return null;
        }

        return deptoService.buscarDeptosDisponibles(fechaLlegadaDate, fechaFinDate, comuna, valorMaximo);
    }

}
