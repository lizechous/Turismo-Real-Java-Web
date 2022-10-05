package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.UsuarioSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository //Indica que esta interfaz es de tipo repository (para gestion de la bds)
public interface IUsuarioSistemaRepo extends JpaRepository<UsuarioSistema, Integer> {
    //JPARepository : se le indica el objeto a persistir y el tipo de dato de la PK

    //encontrar usuario sistema por tipoUsuario, trae varios
    //findBy es una palabra reservada donde la consulta de select ya está hecha
    public List<UsuarioSistema> findByTipoUsuario(String tipo); //tiene que tener si o si el nombre de la variable

    UsuarioSistema findByIdUsuario(Integer id);

    //CUIDADO CON LOS ESPACIOS ENTRE =: *********************

    @Transactional
    @Modifying
    @Query("update UsuarioSistema set nombreUsuario=:new_nombre, emailUsuario=:new_email, telefonoUsuario=:new_telefono, rutUsuario=:new_rut where idUsuario=:id_usuario")
    public Integer updateDatos(@Param("id_usuario") Integer idUser,
                               @Param("new_nombre") String newNombre,
                               @Param("new_email") String newEmail,
                               @Param("new_telefono") String newTelefono,
                                          @Param("new_rut") String newRut);

    @Transactional
    @Modifying
    @Query("update UsuarioSistema set passwordUsuario=:new_password where idUsuario=:id_usuario")
    public Integer updatePassword(@Param("new_password") String newPass,
                                  @Param("id_usuario") Integer idUsuario);

    @Transactional
    @Modifying
    @Query("delete from UsuarioSistema where idUsuario=:id_user")
    public Integer deleteUser(@Param("id_user") Integer idUser);

    UsuarioSistema findByEmailUsuarioAndPasswordUsuario(String email, String password);
}
