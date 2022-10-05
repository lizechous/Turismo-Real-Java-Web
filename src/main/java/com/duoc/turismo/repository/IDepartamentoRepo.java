package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.ClienteUsuario;
import com.duoc.turismo.repository.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface IDepartamentoRepo extends JpaRepository<Departamento, Integer> {


    //Listar departamento por region y comuna
    List<Departamento> findByRegionAndComuna(String region, String comuna);

    //Listar por nombre depto
    List<Departamento> findByNombreDepto(String nombreDepto);

    @Query(value =
            "select d.* from "+
                    "mydb.departamento d "+
                    "where "+
                    "(:estado_depto is null or d.estado=:estado_depto) "+
                    "and "+
                    "(:region_depto is null or d.region=:region_depto) "+
                    "and "+
                    "(:comuna_depto is null or d.comuna=:comuna_depto)", nativeQuery = true)
    List<Departamento> buscarDepartamento(@Param("estado_depto") Boolean estado,
                                       @Param("region_depto") String region,
                                       @Param("comuna_depto") String comuna);

    @Query(value =
            "select disp.* from mydb.departamento disp\n" +
                    "where\n" +
                    "(:comuna is null or disp.comuna=:comuna) and\n" +
                    "disp.estado=1 and\n" +
                    "(:valor_maximo is null or disp.valor_diario <= :valor_maximo) and\n" +
                    "disp.id_departamento not in (\n" +
                    "select d.id_departamento from\n" +
                    "mydb.departamento d\n" +
                    "join mydb.reserva r on r.id_departamento_FK = d.id_departamento\n" +
                    "where \n" +
                    "r.id_estado_reserva_FK in (1,6) and\n"+
                    "(:fecha_inicio >= r.fecha_llegada and :fecha_fin <= r.fecha_salida) or\n" +
                    "(:fecha_inicio < r.fecha_llegada and :fecha_fin > r.fecha_llegada and :fecha_fin <= r.fecha_salida) or\n" +
                    "(:fecha_inicio >= r.fecha_llegada and :fecha_inicio < r.fecha_salida and :fecha_fin > r.fecha_salida) or\n" +
                    "(:fecha_inicio < r.fecha_llegada and :fecha_fin > r.fecha_salida))", nativeQuery = true)
    List<Departamento> buscarDepartamentosDisponibles(@Param("fecha_inicio") Date fechaInicio,
                                          @Param("fecha_fin") Date fechaFin,
                                          @Param("comuna") String comuna,
                                          @Param("valor_maximo") Integer valorMaximo);

    @Query(value =
            "select distinct d.comuna from mydb.departamento d\n" +
                    "where d.estado = 1", nativeQuery = true)
    List<String> getComunasDepto();

    Departamento findByIdDepartamento(Integer id);

    //Actualizar datos depto
    @Transactional
    @Modifying
    @Query("update Departamento set valorDiario =:valor_diario, cantidadCamas =:cantidad_camas, " +
            "capacidadHuespedes =:capacidad_huespedes, descripcion =:descripcion where idDepartamento =:id_depto")
    Integer updateDatosDepto(@Param("valor_diario") Integer valorDiario,
                                    @Param("cantidad_camas") Integer cantidadCamas,
                                    @Param("capacidad_huespedes") Integer capacidadHuespedes,
                                    @Param("id_depto") Integer idDepto,
                                    String descripcion);

    //Actualizar estado depto
    @Transactional
    @Modifying
    @Query("update Departamento set estado =:estado_depto where idDepartamento =:id_depto")
    Integer updateDeptoEstado(@Param("estado_depto") Boolean estado, @Param("id_depto") Integer idDepartamento);

}
