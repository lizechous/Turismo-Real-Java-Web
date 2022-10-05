package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.BoletaReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoletaRepo extends JpaRepository<BoletaReserva, Integer> {

}
