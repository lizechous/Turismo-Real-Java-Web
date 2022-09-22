package com.duoc.turismo.controller;

import com.duoc.turismo.config.exceptions.UsuarioSistemaException;
import com.duoc.turismo.repository.model.UsuarioSistema;
import com.duoc.turismo.service.IUsuarioSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuario-sistema") //ruta del controller
public class UsuarioSistemaController {

    @Autowired
    private IUsuarioSistemaService usuarioService;

    //Crear usuario
    @CrossOrigin("http://127.0.0.1:5500")
    @RequestMapping(value = "/save-usuario-sistema", method = RequestMethod.POST) //ruta del servicio
    public ResponseEntity<Boolean> saveUser(@RequestBody UsuarioSistema usuarioSistema) throws UsuarioSistemaException {
        try{
            return new ResponseEntity<>(usuarioService.saveUsuarioSistema(usuarioSistema), HttpStatus.ACCEPTED.OK);
        }catch (UsuarioSistemaException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Listar todos los usuarios
    @RequestMapping(value = "/listar-all-users", method = RequestMethod.GET)
    public ResponseEntity<List> listarTodos() throws UsuarioSistemaException {
        try{
            return new ResponseEntity<>(usuarioService.findAllUsuarios(), HttpStatus.FOUND);
        }catch (UsuarioSistemaException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Listar usuarios por tipo
    @RequestMapping(value = "/listar-por-tipo", method = RequestMethod.GET)
    public ResponseEntity<List> findByTipoUsuario(@RequestParam String tipo) throws UsuarioSistemaException{
        try{
        return new ResponseEntity<>(usuarioService.findByTipoUsuario(tipo), HttpStatus.FOUND);
        }catch (UsuarioSistemaException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //Encontrar usuario por id
    @RequestMapping(value = "/listar-por-id-user", method = RequestMethod.GET)
    public ResponseEntity<Optional> encontrarUsuario(@RequestParam Integer id) throws UsuarioSistemaException {
        try{
            return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.FOUND);
        }catch (UsuarioSistemaException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Actualizar datos usuario (no password, ni id)
    @RequestMapping(value = "/update-datos-user", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateDatosUsuario(@RequestParam("id_usuario") Integer idUser, @RequestParam("new_nombre") String newNombre,
                                      @RequestParam("new_email") String newEmail, @RequestParam("new_telefono") String newTelefono,
                                      @RequestParam("new_rut") String newRut) throws UsuarioSistemaException {
        try{
            return new ResponseEntity<>(usuarioService.updateDatos(idUser, newNombre, newEmail, newTelefono, newRut), HttpStatus.ACCEPTED);
        }catch (UsuarioSistemaException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Actualizar contrasena
    @RequestMapping(value = "/update-password-user", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updatePassword(String pass, Integer idUsuario) throws UsuarioSistemaException {
        try{
            return new ResponseEntity<>(usuarioService.updatePassword(pass, idUsuario), HttpStatus.ACCEPTED);
        }catch (UsuarioSistemaException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Eliminar usuario
    @RequestMapping(value = "/delete-user", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteUser(@RequestParam("id_user") Integer idUser) throws UsuarioSistemaException {
        try{
            return new ResponseEntity<>(usuarioService.deleteUser(idUser), HttpStatus.ACCEPTED);
        }catch (UsuarioSistemaException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
