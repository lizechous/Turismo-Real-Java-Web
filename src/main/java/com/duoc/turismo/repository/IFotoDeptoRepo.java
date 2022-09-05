package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.FotoDepto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFotoDeptoRepo extends JpaRepository<FotoDepto, Integer> {
}
