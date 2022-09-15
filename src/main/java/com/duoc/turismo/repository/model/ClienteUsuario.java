package com.duoc.turismo.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "CLIENTE_USUARIO")
public class ClienteUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @Column(name = "rut_cliente", nullable = false, length = 12)
    private String rutCliente;

    @Column(name = "nombre_cliente", nullable = false, length = 45)
    private String nombreCliente;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "genero", nullable = false, length = 10)
    private String genero;

    @Column(name = "password_cliente", nullable = false, length = 80)
    private String passwordCliente;

    @Column(name = "email_cliente", nullable = false, length = 45)
    private String emailCliente;

    @Column(name = "telefono_cliente", nullable = false, length = 12)
    private String telefonoCliente;

    @Column(name = "estado_cuenta", nullable = false, length = 12)
    private String estadoCuenta;

    @OneToMany(mappedBy = "clienteUsuario", cascade = CascadeType.ALL)
    private List<MedioDePago> medioDePagoList;

    @OneToMany(mappedBy = "clienteUsuario", cascade = CascadeType.ALL)
    private List<ImagenCarnet> imagenCarnetList;

    @ManyToOne
    @JoinColumn(name = "estado_rut_FK")
    private EstadoRut estadoRut;

    public Integer getIdCliente() {
        return idCliente;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public List<MedioDePago> getMedioDePagoList() {
        return medioDePagoList;
    }

    public void setMedioDePagoList(List<MedioDePago> medioDePagoList) {
        this.medioDePagoList = medioDePagoList;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public List<ImagenCarnet> getImagenCarnetList() {
        return imagenCarnetList;
    }

    public void setImagenCarnetList(List<ImagenCarnet> imagenCarnetList) {
        this.imagenCarnetList = imagenCarnetList;
    }

    public EstadoRut getEstadoRut() {
        return estadoRut;
    }

    public void setEstadoRut(EstadoRut estadoRut) {
        this.estadoRut = estadoRut;
    }
}
