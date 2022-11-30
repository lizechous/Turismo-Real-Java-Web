package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.SolicitudServicioExtra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISolicitudServicioExtraRepo extends JpaRepository<SolicitudServicioExtra, Integer> {

    SolicitudServicioExtra findByIdSolicitud(Integer id);

    @Query(value =
            "select s.* from mydb.solicitud_servicio_extra s", nativeQuery = true)
    List<SolicitudServicioExtra> buscarSolicitudes();

    @Query(value =
            "select s.* from mydb.solicitud_servicio_extra s\n" +
                    "join mydb.reserva r on r.id_reserva = s.id_reserva_fk\n" +
                    "where r.id_cliente_FK =:id_cliente", nativeQuery = true)
    List<SolicitudServicioExtra> buscarSolicitudesCliente(@Param("id_cliente") Integer idCliente);

}
