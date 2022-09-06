package com.duoc.turismo.controller;

import com.duoc.turismo.repository.model.ClienteUsuario;
import com.duoc.turismo.service.IClienteUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/cliente")
public class ClienteUsuarioController {

    @Autowired
    IClienteUsuarioService iClienteUsuarioService;

    @RequestMapping(value = "/crear-cuenta-cliente", method = RequestMethod.POST)
    public void crearCuentaCLiente(@RequestBody ClienteUsuario clienteUsuario){
        iClienteUsuarioService.crearCuentaCLiente(clienteUsuario);
    }
}
