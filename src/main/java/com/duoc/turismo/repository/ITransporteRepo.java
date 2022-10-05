package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Departamento;
import com.duoc.turismo.repository.model.ServicioExtra;
import com.duoc.turismo.repository.model.Tour;
import com.duoc.turismo.repository.model.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransporteRepo extends JpaRepository<Transporte, Integer> {
    List<Transporte> findByRegionAndComunaAndEstado(String region, String comuna, Boolean estado);

    Transporte findByIdServicioExtra(Integer idServicio);

    List<Transporte> findByEstado(Boolean estado);

    @Query(value = "select distinct s.region from " +
            "mydb.servicio_extra s " +
            "join mydb.transporte t on s.id_servicio_extra = t.id_servicio_extra_FK "+
            "where s.estado = 1", nativeQuery = true)
    List<String> getRegionesTransporte();

    @Query(value = "select distinct s.comuna from " +
            "mydb.servicio_extra s " +
            "join mydb.transporte t on s.id_servicio_extra = t.id_servicio_extra_FK " +
            "where s.region=:nombre_region "+
            "and s.estado = 1", nativeQuery = true)
    List<String> getComunasTransporte(@Param("nombre_region") String nombreRegion);

}
