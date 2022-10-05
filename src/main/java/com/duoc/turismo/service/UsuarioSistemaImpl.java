package com.duoc.turismo.service;

import com.duoc.turismo.config.exceptions.UsuarioSistemaException;
import com.duoc.turismo.repository.IUsuarioSistemaRepo;
import com.duoc.turismo.repository.model.UsuarioSistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Con esto le indicamos que pertenece a la capa servicio
public class UsuarioSistemaImpl implements IUsuarioSistemaService{

    @Autowired //Con @Autowired llamamos a la instancia de UsuarioSistemaRepo
    //De esta manera conectamos la capa service con repository
    private IUsuarioSistemaRepo userSistemaRepo;


    @Override
    public Boolean saveUsuarioSistema(UsuarioSistema usuarioSistema) throws UsuarioSistemaException {
        try {
            userSistemaRepo.save(usuarioSistema);
            return true;
        }catch (Exception e){
            throw new UsuarioSistemaException("Error al crear usuario");
        }
    }

    @Override
    public List<UsuarioSistema> findAllUsuarios() throws UsuarioSistemaException {
        List<UsuarioSistema> result = userSistemaRepo.findAll();

        if(result == null ){
            throw new UsuarioSistemaException("Error al listar usuarios");
        }
        return result;
    }

    @Override
    public List<UsuarioSistema> findByTipoUsuario(String tipo) throws UsuarioSistemaException {
        List<UsuarioSistema> lista = userSistemaRepo.findByTipoUsuario(tipo);
        if (lista == null) {
            throw new UsuarioSistemaException("Error, lista vacía");
        }
        return lista;
    }

    @Override
    public Optional<UsuarioSistema> findById(Integer id) throws UsuarioSistemaException {
        Optional<UsuarioSistema> result = userSistemaRepo.findById(id);
        if (result == null){
            throw new UsuarioSistemaException("Usuario no ecnontrado");
        }
        return result;
    }

    @Override
    public void updateDatos(UsuarioSistema usuarioSistema) throws UsuarioSistemaException {

        try{
            userSistemaRepo.save(usuarioSistema);
        }catch (Exception e){
            throw new UsuarioSistemaException("Error al actualizar usuario sistema");
        }

    }

    @Override
    public Boolean updatePassword(String pass, Integer idUsuario) throws UsuarioSistemaException {

        try{
            Integer affectedRows = userSistemaRepo.updatePassword(pass, idUsuario);
            return affectedRows > 0;
        }catch (Exception e){
            throw new UsuarioSistemaException("Error al actualizar contraseña usuario sistema");
        }

    }

    @Override
    public Boolean deleteUser(Integer idUser) throws UsuarioSistemaException {
        try {
            Integer deleteRows = userSistemaRepo.deleteUser(idUser);
            return deleteRows > 0;
        }catch (Exception e){
            throw new UsuarioSistemaException("Error al eliminar usuario sistema");
        }

    }

    @Override
    public UsuarioSistema login(String email, String password) {
        return userSistemaRepo.findByEmailUsuarioAndPasswordUsuario(email,password);
    }
}
