package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Comuna;
import com.duoc.turismo.repository.model.Departamento;
import com.duoc.turismo.repository.model.ServicioExtra;
import com.duoc.turismo.repository.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITourRepo extends JpaRepository<Tour, Integer> {

    //propio de jpa
    List<Tour> findByRegionAndComunaAndEstado(String region, String comuna, Boolean estado);

    Tour findByIdServicioExtra(Integer idServicio);

    List<Tour> findByEstado(Boolean estado);;

    @Query(value = "select distinct s.region from " +
            "mydb.servicio_extra s " +
            "join mydb.tour t on s.id_servicio_extra = t.id_servicio_extra_FK "+
            "where s.estado = 1", nativeQuery = true)
    List<String> getRegionesTour();

    @Query(value = "select distinct s.comuna from " +
            "mydb.servicio_extra s " +
            "join mydb.tour t on s.id_servicio_extra = t.id_servicio_extra_FK " +
            "where s.region=:nombre_region "+
            "and s.estado = 1", nativeQuery = true)
    List<String> getComunasTour(@Param("nombre_region") String nombreRegion);
}
