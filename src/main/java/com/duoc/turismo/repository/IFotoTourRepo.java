package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.FotoTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFotoTourRepo extends JpaRepository<FotoTour, Integer> {
}
