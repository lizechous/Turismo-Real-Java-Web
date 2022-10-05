package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Inventario;
import com.duoc.turismo.repository.model.ServicioDepto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IServicioDeptoRepo extends JpaRepository<ServicioDepto, Integer> {

    //Actualizar servicio depto
    @Transactional
    @Modifying
    @Query("update ServicioDepto set tipoServicioDepto =: tipo_servicio where idServicioDepto =: id_servicio_depto")
    ServicioDepto updateServicioDepto(@Param("tipo_servicio") String tipoServicioDepto,
                                      @Param("id_servicio_depto") Integer idServicioDepto);


    //Eliminar servicio por id
    void deleteById(Integer idServicioDepto);

    ServicioDepto findByIdServicioDepto(Integer id);

}
