package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventarioRepo extends JpaRepository<Inventario, Integer> {
}
