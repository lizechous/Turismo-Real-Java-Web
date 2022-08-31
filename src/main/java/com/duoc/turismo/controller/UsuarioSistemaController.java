package com.duoc.turismo.controller;

import com.duoc.turismo.repository.model.UsuarioSistema;
import com.duoc.turismo.service.IUsuarioSistemaService;
import com.duoc.turismo.service.UsuarioSistemaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuario-sistema") //ruta del controller
public class UsuarioSistemaController {

    @Autowired
    private IUsuarioSistemaService usuarioService;

    //Crear usuario
    @RequestMapping(value = "/save-usuario-sistema", method = RequestMethod.POST) //ruta del servicio
    public boolean saveUser(@RequestBody UsuarioSistema usuarioSistema){
        return usuarioService.saveUsuarioSistema(usuarioSistema);
    }

    //Listar todos los usuarios
    @RequestMapping(value = "/listar-all-users", method = RequestMethod.GET)
    public List<UsuarioSistema> listarTodos(){
        return usuarioService.findAllUsuarios();
    }

    //Listar usuarios por tipo
    @RequestMapping(value = "/listar-por-tipo", method = RequestMethod.GET)
    public List<UsuarioSistema> findByTipoUsuario(@RequestParam String tipo){
        return usuarioService.findByTipoUsuario(tipo);
    }

    //Encontrar usuario por id
    @RequestMapping(value = "/listar-por-id-user", method = RequestMethod.GET)
    public Optional<UsuarioSistema> encontrarUsuario(@RequestParam Integer id){
        return usuarioService.findById(id);
    }

    //Actualizar datos usuario (no password, ni id)
    @RequestMapping(value = "/update-datos-user", method = RequestMethod.PUT)
    public Integer updateDatosUsuario(@RequestParam("id_usuario") Integer idUser, @RequestParam("new_nombre") String newNombre,
                                      @RequestParam("new_email") String newEmail, @RequestParam("new_telefono") String newTelefono,
                                      @RequestParam("new_rut") String newRut) {
        return usuarioService.updateDatos(idUser, newNombre, newEmail, newTelefono, newRut);
    }

    //Actualizar contrasena
    @RequestMapping(value = "/update-password-user", method = RequestMethod.PUT)
    public Boolean updatePassword(String pass, Integer idUsuario){
        return usuarioService.updatePassword(pass, idUsuario);
    }

    //Eliminar usuario
    @RequestMapping(value = "/delete-user", method = RequestMethod.DELETE)
    public Integer deleteUser(@RequestParam("id_user") Integer idUser) {
        return usuarioService.deleteUser(idUser);
    }


}
