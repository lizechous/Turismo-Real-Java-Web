package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.CondicionesDeUso;
import com.duoc.turismo.repository.model.ServicioDepto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICondicionesDeUsoRepo extends JpaRepository<CondicionesDeUso, Integer> {

}
