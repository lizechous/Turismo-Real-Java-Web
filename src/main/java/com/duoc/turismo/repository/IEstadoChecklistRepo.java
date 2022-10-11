package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.EstadoChecklist;
import com.duoc.turismo.repository.model.EstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoChecklistRepo extends JpaRepository<EstadoChecklist, Integer> {

    EstadoChecklist findByIdEstadoChecklist(Integer idEstado);

}
