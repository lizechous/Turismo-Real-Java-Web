package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.EstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoReservaRepo extends JpaRepository<EstadoReserva, Integer> {

    EstadoReserva findByIdEstadoReserva(Integer idEstadoReserva);

}
