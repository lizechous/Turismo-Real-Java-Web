package com.duoc.turismo.service;

import com.duoc.turismo.repository.model.UsuarioSistema;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Capa servicio que se conecta al repository (*En los metodos se pueden cambiar el tipo de dato de retorno)
//AQUI VAN TODOS LOS METODOS DEL REPOSITORY

public interface IUsuarioSistemaService {

    //Crear usuarios
    boolean saveUsuarioSistema(UsuarioSistema usuarioSistema);

    //Listar todos los  usuarios
    public List<UsuarioSistema> findAllUsuarios();

    //Listar usuarios por su tipo
    public List<UsuarioSistema> findByTipoUsuario(String tipo);

    //Econtrar usuario por id
    public Optional<UsuarioSistema> findById(Integer id);

    //Actualizar datos usuario por email y telefono
    public Integer updateDatos(Integer idUser, String newNombre, String newEmail, String newTelefono, String newRut);

    //Actualizar contrasena
    public Boolean updatePassword(String pass, Integer idUsuario);

    //Eliminar usuario
    public Integer deleteUser(Integer idUser);
}
