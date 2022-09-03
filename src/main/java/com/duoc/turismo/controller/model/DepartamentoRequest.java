package com.duoc.turismo.controller.model;

import com.duoc.turismo.repository.model.CondicionesDeUso;
import com.duoc.turismo.repository.model.FotoDepto;
import com.duoc.turismo.repository.model.Inventario;
import com.duoc.turismo.repository.model.ServicioDepto;


import java.util.List;

/**
 * SE RECOMIENDA CREAR OBJETOS REQUEST PARA LOS CONTROLLERS, YA QUE ESTOS NO SIEMPRE SON IDENTICOS A LAS ENTITYS,
 * O BIEN LA CONVERSION DE DATOS NO SE PUEDE HACER DIRECTAMENTE (COMO BASE64 A BLOB)
 */

public class DepartamentoRequest {

    private Integer idDepto;
    private String direccion;

    private String nombreDepto;

    private Integer cantidadHabitaciones;

    private Integer cantidadBanios;

    private String estado;

    private String region;

    private String comuna;

    private String dimensiones;

    private Integer capacidadHuespedes;

    private Integer cantidadCamas;

    private String descripcion;

    private Integer valorDiario;

    private Inventario inventario;

    private List<FotoDeptoRequest> fotoDeptoList;

    private List<ServicioDepto> servicioDeptoList;

    private List<CondicionesDeUso> condicionesDeUsoList;

    public Integer getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public Integer getCantidadBanios() {
        return cantidadBanios;
    }

    public void setCantidadBanios(Integer cantidadBanios) {
        this.cantidadBanios = cantidadBanios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Integer getCapacidadHuespedes() {
        return capacidadHuespedes;
    }

    public void setCapacidadHuespedes(Integer capacidadHuespedes) {
        this.capacidadHuespedes = capacidadHuespedes;
    }

    public Integer getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(Integer cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(Integer valorDiario) {
        this.valorDiario = valorDiario;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<FotoDeptoRequest> getFotoDeptoList() {
        return fotoDeptoList;
    }

    public void setFotoDeptoList(List<FotoDeptoRequest> fotoDeptoList) {
        this.fotoDeptoList = fotoDeptoList;
    }

    public List<ServicioDepto> getServicioDeptoList() {
        return servicioDeptoList;
    }

    public void setServicioDeptoList(List<ServicioDepto> servicioDeptoList) {
        this.servicioDeptoList = servicioDeptoList;
    }

    public List<CondicionesDeUso> getCondicionesDeUsoList() {
        return condicionesDeUsoList;
    }

    public void setCondicionesDeUsoList(List<CondicionesDeUso> condicionesDeUsoList) {
        this.condicionesDeUsoList = condicionesDeUsoList;
    }
}
