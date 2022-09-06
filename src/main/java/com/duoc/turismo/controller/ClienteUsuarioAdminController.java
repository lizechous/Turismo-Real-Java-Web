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

    @RequestMapping(value = "/modificar-cliente", method = RequestMethod.POST)
    public ClienteUsuario modificarDatosCliente(@RequestBody ClienteUsuario clienteModificado){
        return iClienteUsuarioService.modificarDatosCliente(clienteModificado);
    }

    @RequestMapping(value = "/listar-clientes", method = RequestMethod.GET)
    public List<ClienteUsuario> listarClientes(){
        return iClienteUsuarioService.listarClientes();
    }

    @RequestMapping(value = "/buscar-por-rut", method = RequestMethod.GET)
    public ClienteUsuario BuscarClientesPorRut(@RequestParam String rutCLiente){
        return iClienteUsuarioService.BuscarClientesPorRut(rutCLiente);
    }

    @RequestMapping(value = "/eliminar-cliente", method = RequestMethod.DELETE)
    public void eliminarCliente(@RequestBody ClienteUsuario clienteUsuario){
        iClienteUsuarioService.eliminarCliente(clienteUsuario);
    }

    @RequestMapping(value = "/suspender-cliente", method = RequestMethod.POST)
    public void suspenderCuentaUsuario(@RequestParam Integer idCliente){
        iClienteUsuarioService.suspenderCuentaUsuario(idCliente);
    }

}
