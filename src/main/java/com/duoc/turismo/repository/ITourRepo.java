package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Departamento;
import com.duoc.turismo.repository.model.ServicioExtra;
import com.duoc.turismo.repository.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITourRepo extends JpaRepository<Tour, Integer> {

    //propio de jpa
    List<Tour> findByRegionAndComuna(String region, String comuna);
}
