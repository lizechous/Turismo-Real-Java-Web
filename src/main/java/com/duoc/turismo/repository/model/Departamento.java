package com.duoc.turismo.repository.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="DEPARTAMENTO")
public class Departamento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_departamento",nullable = false)
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
    private Integer region;

    @Column(name = "comuna", nullable = false, length = 45)
    private Integer comuna;

    @Column(name = "dimensiones", nullable = false, length = 45)
    private Integer dimensiones;

    @Column(name = "capacidad_huespedes", nullable = false)
    private Integer capacidadHuespedes;

    @Column(name = "cantidad_camas", nullable = false)
    private Integer cantidadCamas;

    @Column(name = "descripcion", nullable = false, length = 1000)
    private String descripcion;

    @Column(name = "valor_diario", nullable = false)
    private Integer valorDiario;

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    @OneToOne(mappedBy = "departamento", cascade = CascadeType.ALL)
    private Inventario inventario;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<FotoDepto> fotoDeptoList;

    @ManyToMany(mappedBy = "departamentoList")
    private List<ServicioDepto> servicioDeptoList;

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

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Integer getComuna() {
        return comuna;
    }

    public void setComuna(Integer comuna) {
        this.comuna = comuna;
    }

    public Integer getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(Integer dimensiones) {
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
}
