package com.duoc.turismo.service;

import com.duoc.turismo.repository.model.*;

import java.util.List;

public interface IReservaService {

    Integer reservarDepto(Reserva reserva);

    Reserva obtenerReservaPorId(Integer id);

    void actualizarEstadoReserva(Integer id, Integer estado);

    List<Reserva> obtenerReservasCliente(Integer id);

    List<Reserva> buscarReservasFiltro(String fechaLlegada, String fechaSalida, Integer estado);

    void crearChecklist(Checklist checklist);

    void crearCostoReparacion(CostoReparacion costoReparacion);

    List<Reserva> buscarReservasConMultas(Integer idCliente);

    void pagarMulta(BoletaMulta boletaMulta);

    List<Reserva> buscarReservasParaUnTour(String comuna, String region, Integer cliente);

    void pagarTour(BoletaServicioExtra boleta);

}
