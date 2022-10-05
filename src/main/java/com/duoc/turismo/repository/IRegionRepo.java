package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegionRepo extends JpaRepository<Region, Integer> {
}
