package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.ClienteUsuario;
import com.duoc.turismo.repository.model.ServicioExtra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteUsuarioRepo extends JpaRepository<ClienteUsuario, Integer> {

   public ClienteUsuario findByRutCliente(String rutCliente);
}
