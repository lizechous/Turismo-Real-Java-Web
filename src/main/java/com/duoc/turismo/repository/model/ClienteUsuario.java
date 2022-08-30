package com.duoc.turismo.repository.model;

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

    @Column(name = "estado_rut", nullable = false, length = 15)
    private String estadoRut;

    @Column(name = "estado_cuenta", nullable = false, length = 12)
    private String estadoCuenta;

    @OneToOne(mappedBy = "clienteUsuario")
    private VerificacionPendiente verificacionPendiente;

    @OneToMany(mappedBy = "clienteUsuario", cascade = CascadeType.ALL)
    private List<MedioDePago> medioDePagoList;

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

    public String getEstadoRut() {
        return estadoRut;
    }

    public void setEstadoRut(String estadoRut) {
        this.estadoRut = estadoRut;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public VerificacionPendiente getVerificacionPendiente() {
        return verificacionPendiente;
    }

    public void setVerificacionPendiente(VerificacionPendiente verificacionPendiente) {
        this.verificacionPendiente = verificacionPendiente;
    }

    public List<MedioDePago> getMedioDePagoList() {
        return medioDePagoList;
    }

    public void setMedioDePagoList(List<MedioDePago> medioDePagoList) {
        this.medioDePagoList = medioDePagoList;
    }
}
