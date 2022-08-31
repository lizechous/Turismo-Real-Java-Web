package com.duoc.turismo.service;

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
    public boolean saveUsuarioSistema(UsuarioSistema usuarioSistema) {
        try {
            userSistemaRepo.save(usuarioSistema);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<UsuarioSistema> findAllUsuarios()
    {
        return userSistemaRepo.findAll();
    }

    @Override
    public List<UsuarioSistema> findByTipoUsuario(String tipo) {
        return userSistemaRepo.findByTipoUsuario(tipo);
    }

    @Override
    public Optional<UsuarioSistema> findById(Integer id) {
        return userSistemaRepo.findById(id);
    }

    @Override
    public Integer updateDatos(Integer idUser, String newNombre, String newEmail, String newTelefono, String newRut) {
        return userSistemaRepo.updateDatos(idUser, newNombre, newEmail, newTelefono, newRut);
    }

    @Override
    public Boolean updatePassword(String pass, Integer idUsuario) {
        return userSistemaRepo.updatePassword(pass, idUsuario);
    }

    @Override
    public Integer deleteUser(Integer idUser) {
        return userSistemaRepo.deleteUser(idUser);
    }
}
