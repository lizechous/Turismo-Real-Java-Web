package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Elemento;
import com.duoc.turismo.repository.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IElementoRepo extends JpaRepository<Elemento, Integer> {

    @Transactional
    @Modifying
    @Query("delete from Elemento where idElemento =:id_elemento")
    void eliminarElemento(@Param("id_elemento") Integer idElemento);
}
