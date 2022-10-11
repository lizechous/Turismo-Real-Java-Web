package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.CostoReparacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICostoReparacionRepo extends JpaRepository<CostoReparacion, Integer> {

}
