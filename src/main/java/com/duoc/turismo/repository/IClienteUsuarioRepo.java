package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.ClienteUsuario;
import com.duoc.turismo.repository.model.ServicioExtra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IClienteUsuarioRepo extends JpaRepository<ClienteUsuario, Integer> {

   public ClienteUsuario findByRutCliente(String rutCliente);

   @Modifying
   @Transactional
   @Query("update ClienteUsuario set estado_rut_FK =:estado_rut where idClienteUsuario =:id_cliente")
   Integer updateEstadorutCliente(@Param("estado_rut") Integer estadorutId, @Param("id_cliente") Integer idCliente);

}
