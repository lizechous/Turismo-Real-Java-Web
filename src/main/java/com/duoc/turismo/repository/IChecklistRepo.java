package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Checklist;
import com.duoc.turismo.repository.model.EstadoChecklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChecklistRepo extends JpaRepository<Checklist, Integer> {

}
