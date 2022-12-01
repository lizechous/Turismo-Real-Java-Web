package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.FotoMantencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFotoMantencionRepo extends JpaRepository<FotoMantencion, Integer> {
}
