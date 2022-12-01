package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITourRepo extends JpaRepository<Tour, Integer> {


    @Query(value = "select t.*,s.* from mydb.tour t\n" +
            "join mydb.servicio_extra s on s.id_servicio_extra = t.id_servicio_extra_FK "+
            "where s.estado = 1\n" +
            "and (:p_region = 'Cualquiera' or s.region =:p_region)\n" +
            "and (:p_comuna = 'Cualquiera' or s.comuna =:p_comuna)", nativeQuery = true)
    List<Tour> buscarToursRegionComuna(@Param("p_region") String region, @Param("p_comuna") String comuna);

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
