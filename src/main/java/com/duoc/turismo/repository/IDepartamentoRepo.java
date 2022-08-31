package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartamentoRepo extends JpaRepository<Departamento, Integer> {
}
