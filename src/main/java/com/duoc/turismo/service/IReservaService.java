package com.duoc.turismo.service;

import com.duoc.turismo.repository.model.BoletaMulta;
import com.duoc.turismo.repository.model.Checklist;
import com.duoc.turismo.repository.model.CostoReparacion;
import com.duoc.turismo.repository.model.Reserva;

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

}
