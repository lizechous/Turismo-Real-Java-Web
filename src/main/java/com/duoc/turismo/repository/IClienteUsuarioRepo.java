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
import java.util.List;

@Repository
public interface IClienteUsuarioRepo extends JpaRepository<ClienteUsuario, Integer> {

   @Query(value =
           "select c.* from "+
           "mydb.cliente_usuario c "+
           "join mydb.estado_rut e on e.id_estado_rut = c.estado_rut_FK "+
           "where "+
           "(:estado_rut is null or e.id_estado_rut=:estado_rut) "+
           "and "+
           "(:estado_cuenta is null or c.estado_cuenta=:estado_cuenta) "+
           "and "+
           "(:rut_cliente is null or c.rut_cliente=:rut_cliente)", nativeQuery = true)
   List<ClienteUsuario> buscarCliente(@Param("rut_cliente") String nombreRegion,
                                      @Param("estado_cuenta") String estadoCuenta,
                                      @Param("estado_rut") Integer estadoRut);

   ClienteUsuario findByRutCliente(String rutCliente);

   @Modifying
   @Transactional
   @Query(value="update mydb.cliente_usuario set estado_rut_FK =:estado_rut where id_cliente =:id_cliente", nativeQuery = true)
   Integer updateEstadorutCliente(@Param("estado_rut") Integer estadorutId, @Param("id_cliente") Integer idCliente);

   ClienteUsuario findByEmailClienteAndPasswordCliente(String email, String password);

   ClienteUsuario findByIdCliente(Integer id);

}
