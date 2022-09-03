package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Elemento;
import com.duoc.turismo.repository.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IElementoRepo extends JpaRepository<Elemento, Integer> {
}
