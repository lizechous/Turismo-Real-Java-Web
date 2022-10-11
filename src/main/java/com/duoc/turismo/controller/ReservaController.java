package com.duoc.turismo.controller;

import com.duoc.turismo.config.exceptions.UsuarioSistemaException;
import com.duoc.turismo.repository.model.BoletaMulta;
import com.duoc.turismo.repository.model.Checklist;
import com.duoc.turismo.repository.model.CostoReparacion;
import com.duoc.turismo.repository.model.Reserva;
import com.duoc.turismo.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reserva")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

    @CrossOrigin
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public ResponseEntity<Integer> crear(@RequestBody Reserva reserva) throws UsuarioSistemaException {
        try{
            return new ResponseEntity<>(reservaService.reservarDepto(reserva),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/actualizar-estado", method = RequestMethod.POST)
    public ResponseEntity<Void> actualizarEstado(@RequestParam Integer id,
                                                    @RequestParam Integer estado) throws UsuarioSistemaException {
        try{
            reservaService.actualizarEstadoReserva(id, estado);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/obtener-reserva", method = RequestMethod.GET)
    public ResponseEntity<Reserva> obtenerReserva(@RequestParam Integer id) throws UsuarioSistemaException {
        try{
            return new ResponseEntity<>(reservaService.obtenerReservaPorId(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/obtener-reservas-cliente", method = RequestMethod.GET)
    public ResponseEntity<List<Reserva>> obtenerReservasPorCliente(@RequestParam Integer id) throws UsuarioSistemaException {
        try{
            return new ResponseEntity<>(reservaService.obtenerReservasCliente(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/obtener-reservas-filtro", method = RequestMethod.GET)
    public ResponseEntity<List<Reserva>> obtenerReservasFiltro(@RequestParam(required = false) String fechaLlegada,
                                                               @RequestParam(required = false) String fechaSalida,
                                                               @RequestParam(required = false) Integer estado) throws UsuarioSistemaException {
        try{
            return new ResponseEntity<>(reservaService.buscarReservasFiltro(fechaLlegada, fechaSalida, estado),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/crear-checklist", method = RequestMethod.POST)
    public ResponseEntity<Void> crearChecklist(@RequestBody Checklist checklist){
        try{
            reservaService.crearChecklist(checklist);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/crear-costo-reparacion", method = RequestMethod.POST)
    public ResponseEntity<Void> crearCostoReparacion(@RequestBody CostoReparacion costoReparacion){
        try{
            reservaService.crearCostoReparacion(costoReparacion);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/obtener-reservas-multas", method = RequestMethod.GET)
    public ResponseEntity<List<Reserva>> buscarReservasConMultas(@RequestParam Integer idCliente) throws UsuarioSistemaException {
        try{
            return new ResponseEntity<>(reservaService.buscarReservasConMultas(idCliente),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/pagar-multa", method = RequestMethod.POST)
    public ResponseEntity<Void> pagarMulta(@RequestBody BoletaMulta boletaMulta){
        try{
            reservaService.pagarMulta(boletaMulta);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
