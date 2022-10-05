package com.duoc.turismo.service;

import com.duoc.turismo.repository.model.Reserva;

import java.util.List;

public interface IReservaService {

    Integer reservarDepto(Reserva reserva);

    Reserva obtenerReservaPorId(Integer id);

    void actualizarEstadoReserva(Integer id, Integer estado);

    List<Reserva> obtenerReservasCliente(Integer id);

}
