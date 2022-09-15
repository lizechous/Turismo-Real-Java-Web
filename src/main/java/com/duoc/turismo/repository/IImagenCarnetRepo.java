package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.FotoDepto;
import com.duoc.turismo.repository.model.ImagenCarnet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImagenCarnetRepo extends JpaRepository<ImagenCarnet, Integer> {
}
