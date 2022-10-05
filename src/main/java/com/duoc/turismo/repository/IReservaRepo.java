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

}
