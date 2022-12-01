package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Mantencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMantencionRepo extends JpaRepository<Mantencion, Integer> {

    @Query(value =
            "select m.* from mydb.mantencion m " +
                    "where m.id_departamento_FK =:p_departamento", nativeQuery = true)
    List<Mantencion> buscarMantencionesDepto(@Param("p_departamento") Integer idDepartamento);

    Mantencion findByIdMantencion(Integer idMantencion);

}
