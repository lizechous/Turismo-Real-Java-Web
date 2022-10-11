package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.BoletaMulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoletaMultaRepo extends JpaRepository<BoletaMulta, Integer> {

}
