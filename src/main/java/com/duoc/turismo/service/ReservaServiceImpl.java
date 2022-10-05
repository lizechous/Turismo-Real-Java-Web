package com.duoc.turismo.service;

import com.duoc.turismo.repository.*;
import com.duoc.turismo.repository.model.Acompanante;
import com.duoc.turismo.repository.model.BoletaReserva;
import com.duoc.turismo.repository.model.EstadoReserva;
import com.duoc.turismo.repository.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReservaServiceImpl implements IReservaService{

    @Autowired
    IReservaRepo reservaRepo;

    @Autowired
    IBoletaRepo boletaRepo;

    @Autowired
    IAcompananteRepo acompananteRepo;

    @Override
    public Integer reservarDepto(Reserva reserva) {
        BoletaReserva boletaReserva = new BoletaReserva();
        boletaReserva.setMontoBoleta(reserva.getMontoPrepago());
        boletaReserva.setFechaEmision(new Date());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaLlegadaDate = null;
        Date fechaFinDate = null;
        try {
            fechaLlegadaDate = formatter.parse(reserva.getFechaLlegadaString());
            fechaFinDate = formatter.parse(reserva.getFechaSalidaString());
        } catch (ParseException e) {
            return null;
        }

        reserva.setFechaLlegada(fechaLlegadaDate);
        reserva.setFechaSalida(fechaFinDate);
        reserva.setFechaReserva(new Date());

        Reserva reservaGuardada = reservaRepo.save(reserva);

        for(Acompanante acompanante: reserva.getAcompananteList()){
            acompanante.setReserva(reservaGuardada);
            acompananteRepo.save(acompanante);
        }

        boletaReserva.setReserva(reservaGuardada);

        boletaRepo.save(boletaReserva);

        return reservaGuardada.getIdReserva();
    }

    @Override
    public Reserva obtenerReservaPorId(Integer id) {
        return reservaRepo.findByIdReserva(id);
    }

    @Override
    public void actualizarEstadoReserva(Integer id, Integer estado) {
        Reserva reservaGuardada = reservaRepo.findByIdReserva(id);

        EstadoReserva estadoReserva = new EstadoReserva();
        estadoReserva.setIdEstadoReserva(estado);

        reservaGuardada.setEstadoReserva(estadoReserva);
        reservaRepo.save(reservaGuardada);
    }

    @Override
    public List<Reserva> obtenerReservasCliente(Integer id) {
        return reservaRepo.findByClienteUsuario(id);
    }

}
