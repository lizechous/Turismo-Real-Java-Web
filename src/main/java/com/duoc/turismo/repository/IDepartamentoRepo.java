package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IDepartamentoRepo extends JpaRepository<Departamento, Integer> {


    //Listar departamento por region y comuna
    List<Departamento> findByRegionAndComuna(String region, String comuna);

    //Listar por nombre depto
    List<Departamento> findByNombreDepto(String nombreDepto);

    //Actualizar datos depto
    @Transactional
    @Modifying
    @Query("update Departamento set valorDiario =:valor_diario, cantidadCamas =:cantidad_camas, " +
            "capacidadHuespedes =:capacidad_huespedes, descripcion =:descripcion where idDepartamento =:id_depto")
    Departamento updateDatosDepto(@Param("valor_diario") Integer valorDiario,
                                    @Param("cantidad_camas") Integer cantidadCamas,
                                    @Param("capacidad_huespedes") Integer capacidadHuespedes,
                                    @Param("id_depto") Integer idDepto,
                                    String descripcion);

    //Actualizar estado depto
    @Transactional
    @Modifying
    @Query("update Departamento set estado =:estado_depto where idDepartamento =:id_depto")
    Departamento updateDeptoEstado(@Param("estado_depto") String estado, @Param("id_depto") Integer idDepartamento);


}
