package com.duoc.turismo.service;

import com.duoc.turismo.repository.*;
import com.duoc.turismo.repository.model.*;
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

    @Autowired
    IChecklistRepo checklistRepo;

    @Autowired
    ICostoReparacionRepo costoReparacionRepo;

    @Autowired
    IBoletaMultaRepo boletaMultaRepo;

    @Autowired
    IBoletaServicioExtraRepo boletaServicioExtraRepo;

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

    @Override
    public List<Reserva> buscarReservasFiltro(String fechaLlegada, String fechaSalida, Integer estado) {
        return reservaRepo.buscarReservasPorFiltro(fechaLlegada, fechaSalida, estado);
    }

    @Override
    public void crearChecklist(Checklist checklist) {
        Reserva reserva = new Reserva();
        reserva.setIdReserva(checklist.getIdReserva());
        checklist.setReserva(reserva);
        checklistRepo.save(checklist);
    }

    @Override
    public void crearCostoReparacion(CostoReparacion costoReparacion) {
        costoReparacion.setFechaEmision(new Date());
        Reserva reserva = new Reserva();
        reserva.setIdReserva(costoReparacion.getIdReserva());
        costoReparacion.setReserva(reserva);
        costoReparacionRepo.save(costoReparacion);
    }

    @Override
    public List<Reserva> buscarReservasConMultas(Integer idCliente) {
        return reservaRepo.buscarReservasConMultas(idCliente);
    }

    @Override
    public void pagarMulta(BoletaMulta boletaMulta) {
        boletaMulta.setFechaMulta(new Date());
        Reserva reserva = new Reserva();
        reserva.setIdReserva(boletaMulta.getIdReserva());
        boletaMulta.setReserva(reserva);

        boletaMultaRepo.save(boletaMulta);
    }

    @Override
    public List<Reserva> buscarReservasParaUnTour(String comuna, String region, Integer cliente) {
        return reservaRepo.buscarReservasParaUnTour(comuna, region, cliente);
    }

    @Override
    public void pagarTour(BoletaServicioExtra boleta) {
        Reserva reserva = new Reserva();
        reserva.setIdReserva(boleta.getIdReserva());
        boleta.setReserva(reserva);
        boletaServicioExtraRepo.save(boleta);
    }

}
