package com.duoc.turismo.controller;

import com.duoc.turismo.controller.model.LoginUserRequest;
import com.duoc.turismo.controller.model.RegistrarClienteRequest;
import com.duoc.turismo.gateway.IRutGateway;
import com.duoc.turismo.repository.model.ClienteUsuario;
import com.duoc.turismo.service.IClienteUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/cliente")
public class ClienteUsuarioController {

    @Autowired
    private IClienteUsuarioService iClienteUsuarioService;

    @Autowired
    private IRutGateway iRutGateway;

    @CrossOrigin
    @RequestMapping(value = "/crear-cuenta-cliente", method = RequestMethod.POST)
    public ClienteUsuario crearCuentaCLiente(@RequestBody RegistrarClienteRequest clienteUsuarioRequest) throws Exception {
        return iClienteUsuarioService.crearCuentaCLiente(clienteUsuarioRequest);
    }

    @CrossOrigin
    @RequestMapping(value = "/validar-rut", method = RequestMethod.GET)
    public ResponseEntity<String> validarRut(@RequestParam String rut){
        return new ResponseEntity<>(iRutGateway.rutValido(rut), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/login-user", method = RequestMethod.POST)
    public ResponseEntity<ClienteUsuario> loginUser(@RequestBody LoginUserRequest login){
        return new ResponseEntity<ClienteUsuario>(iClienteUsuarioService.loginUser(login.getEmail(), login.getPassword()), HttpStatus.OK);
    }
}
