package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservaRepo extends JpaRepository<Reserva, Integer> {

    Reserva findByIdReserva(Integer id);

    @Query(value =
            "select * from mydb.reserva \n" +
                    "where id_cliente_FK =:id_cliente", nativeQuery = true)
    List<Reserva> findByClienteUsuario(@Param("id_cliente") Integer id);

    @Query(value =
        "select * from mydb.reserva \n" +
                "where\n" +
                "(:p_fecha_llegada is null or :p_fecha_llegada = fecha_llegada) and\n" +
                "(:p_fecha_salida is null or :p_fecha_salida = fecha_salida) and\n" +
                "(:p_estado is null or :p_estado = id_estado_reserva_FK)", nativeQuery = true)
    List<Reserva> buscarReservasPorFiltro(@Param("p_fecha_llegada") String fechaLlegada,
                                          @Param("p_fecha_salida") String fechaSalida,
                                          @Param("p_estado") Integer estado);

    @Query(value =
        "select r.* from \n" +
                "mydb.reserva r \n" +
                "inner join mydb.costos_reparacion c on c.id_reserva_FK = r.id_reserva\n" +
                "where r.id_estado_reserva_FK = 6 and  r.id_cliente_FK=:p_id_cliente", nativeQuery = true)
    List<Reserva> buscarReservasConMultas(@Param("p_id_cliente") Integer idCliente);

}
