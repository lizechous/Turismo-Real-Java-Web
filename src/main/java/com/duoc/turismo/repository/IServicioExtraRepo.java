package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Reserva;
import com.duoc.turismo.repository.model.ServicioExtra;
import com.duoc.turismo.repository.model.Tour;
import com.duoc.turismo.repository.model.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServicioExtraRepo extends JpaRepository<ServicioExtra, Integer> {

}
