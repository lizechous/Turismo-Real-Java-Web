package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.BoletaServicioExtra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoletaServicioExtraRepo extends JpaRepository<BoletaServicioExtra, Integer> {

}
