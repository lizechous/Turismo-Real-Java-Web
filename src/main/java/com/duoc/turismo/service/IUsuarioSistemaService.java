package com.duoc.turismo.service;

import com.duoc.turismo.config.exceptions.UsuarioSistemaException;
import com.duoc.turismo.repository.model.UsuarioSistema;

import java.util.List;
import java.util.Optional;

//Capa servicio que se conecta al repository (*En los metodos se pueden cambiar el tipo de dato de retorno)
//AQUI VAN TODOS LOS METODOS DEL REPOSITORY

public interface IUsuarioSistemaService {

    //Crear usuarios
    Boolean saveUsuarioSistema(UsuarioSistema usuarioSistema) throws UsuarioSistemaException;

    //Listar todos los  usuarios
    public List<UsuarioSistema> findAllUsuarios() throws UsuarioSistemaException;

    //Listar usuarios por su tipo
    public List<UsuarioSistema> findByTipoUsuario(String tipo) throws UsuarioSistemaException;

    //Econtrar usuario por id
    public Optional<UsuarioSistema> findById(Integer id) throws UsuarioSistemaException;

    //Actualizar datos usuario por datos
    public void updateDatos(UsuarioSistema usuarioSistema) throws UsuarioSistemaException;

    //Actualizar contrasena
    public Boolean updatePassword(String pass, Integer idUsuario) throws UsuarioSistemaException;

    //Eliminar usuario
    public Boolean deleteUser(Integer idUser) throws UsuarioSistemaException;

    UsuarioSistema login(String email, String password);
}
