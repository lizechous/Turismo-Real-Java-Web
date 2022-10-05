package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComunaRepo extends JpaRepository<Comuna, Integer> {

    @Query(value = "SELECT C.id_comuna, C.nombre_comuna, C.id_region_FK FROM mydb.Comuna C " +
            "INNER JOIN mydb.REGION R ON R.id_region = C.id_region_FK " +
            "where R.nombre_region=:nombre_region", nativeQuery = true)
    List<Comuna> getComunasPorRegion(@Param("nombre_region") String nombreRegion);

}
