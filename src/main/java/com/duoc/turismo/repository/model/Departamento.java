package com.duoc.turismo.repository.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="DEPARTAMENTO")
public class Departamento {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Integer idDepartamento;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @Column(name = "nombre_depto", nullable = false, length = 45)
    private String nombreDepto;

    @Column(name = "cantidad_habitaciones", nullable = false)
    private Integer cantidadHabitaciones;

    @Column(name = "cantidad_banios", nullable = false)
    private Integer cantidadBanios;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @Column(name = "region", nullable = false, length = 45)
    private String region;

    @Column(name = "comuna", nullable = false, length = 45)
    private String comuna;

    @Column(name = "dimensiones", nullable = false, length = 45)
    private String dimensiones;

    @Column(name = "capacidad_huespedes", nullable = false)
    private Integer capacidadHuespedes;

    @Column(name = "cantidad_camas", nullable = false)
    private Integer cantidadCamas;

    @Column(name = "descripcion", nullable = false, length = 1000)
    private String descripcion;

    @Column(name = "valor_diario", nullable = false)
    private Integer valorDiario;

    @OneToOne(mappedBy = "departamento", cascade = CascadeType.ALL)
    private Inventario inventario;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<FotoDepto> fotoDeptoList;

    @ManyToMany(mappedBy = "departamentoList", cascade = CascadeType.ALL)
    private List<ServicioDepto> servicioDeptoList;

    @ManyToMany(mappedBy = "departamentoList", cascade = CascadeType.ALL)
    private List<CondicionesDeUso> condicionesDeUsoList;

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
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

    public List<ServicioDepto> getServicioDeptoList() {
        return servicioDeptoList;
    }

    public void setServicioDeptoList(List<ServicioDepto> servicioDeptoList) {
        this.servicioDeptoList = servicioDeptoList;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<FotoDepto> getFotoDeptoList() {
        return fotoDeptoList;
    }

    public void setFotoDeptoList(List<FotoDepto> fotoDeptoList) {
        this.fotoDeptoList = fotoDeptoList;
    }

    public List<CondicionesDeUso> getCondicionesDeUsoList() {
        return condicionesDeUsoList;
    }

    public void setCondicionesDeUsoList(List<CondicionesDeUso> condicionesDeUsoList) {
        this.condicionesDeUsoList = condicionesDeUsoList;
    }
}
