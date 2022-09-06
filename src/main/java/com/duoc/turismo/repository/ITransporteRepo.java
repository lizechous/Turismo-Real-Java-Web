package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Departamento;
import com.duoc.turismo.repository.model.ServicioExtra;
import com.duoc.turismo.repository.model.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransporteRepo extends JpaRepository<Transporte, Integer> {
    List<Transporte> findByRegionAndComuna(String region, String comuna);
}
