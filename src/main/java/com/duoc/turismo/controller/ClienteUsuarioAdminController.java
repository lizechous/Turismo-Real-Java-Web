package com.duoc.turismo.controller;

import com.duoc.turismo.repository.model.ClienteUsuario;
import com.duoc.turismo.service.IClienteUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cliente-usuario")
public class ClienteUsuarioAdminController {

    @Autowired
    private IClienteUsuarioService iClienteUsuarioService;

    @CrossOrigin
    @RequestMapping(value = "/modificar-cliente", method = RequestMethod.POST)
    public ClienteUsuario modificarDatosCliente(@RequestBody ClienteUsuario clienteModificado){
        return iClienteUsuarioService.modificarDatosCliente(clienteModificado);
    }

    @CrossOrigin
    @RequestMapping(value = "/listar-clientes", method = RequestMethod.GET)
    public List<ClienteUsuario> listarClientes(){
        return iClienteUsuarioService.listarClientes();
    }

    @CrossOrigin
    @RequestMapping(value = "/buscar-id", method = RequestMethod.GET)
    public ClienteUsuario buscarPorId(@RequestParam Integer id){
        return iClienteUsuarioService.buscarPorId(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/buscar-por-rut", method = RequestMethod.GET)
    public ClienteUsuario buscarPorRut(@RequestParam String rutCliente){
        return iClienteUsuarioService.buscarPorRut(rutCliente);
    }

    @CrossOrigin
    @RequestMapping(value = "/buscar-clientes", method = RequestMethod.GET)
    public List<ClienteUsuario> BuscarClientesPorRut(@RequestParam(required=false) String rutCliente,
                                               @RequestParam(required=false) String estadoCuenta,
                                               @RequestParam(required=false) Integer estadoRut){
        return iClienteUsuarioService.buscarClientes(rutCliente, estadoCuenta, estadoRut);
    }

    @CrossOrigin
    @RequestMapping(value = "/eliminar-cliente", method = RequestMethod.DELETE)
    public void eliminarCliente(@RequestBody ClienteUsuario clienteUsuario){
        iClienteUsuarioService.eliminarCliente(clienteUsuario);
    }

    @CrossOrigin
    @RequestMapping(value = "/suspender-cliente", method = RequestMethod.POST)
    public void modificarEstadoCuentaCliente(@RequestParam Integer idUsuario,@RequestParam String estadoCuenta){
        iClienteUsuarioService.modificarEstadoCuentaCliente(idUsuario, estadoCuenta);
    }

    @CrossOrigin
    @RequestMapping(value = "/aprobar-rut-cliente", method = RequestMethod.POST)
    public Integer updateEstadorutCliente(@RequestParam Integer estadoRutId, @RequestParam Integer idCliente) {
        return iClienteUsuarioService.updateEstadorutCliente(estadoRutId, idCliente);
    }
}
