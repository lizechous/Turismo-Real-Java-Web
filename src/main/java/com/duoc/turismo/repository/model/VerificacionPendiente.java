package com.duoc.turismo.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "VERIFICACION_PENDIENTE")
public class VerificacionPendiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_verificacion_pendiente", nullable = false)
    private Integer idVerificacionPendiente;

    @Column(name = "estado_verificacion", nullable = false, length = 15)
    private String estadoVerificacion;

    @OneToOne
    @JoinColumn(name = "id_cliente_FK")
    private ClienteUsuario clienteUsuario;

    @ManyToOne
    @JoinColumn(name = "id_estado_rut_FK")
    private EstadoRut estadoRut;

    public Integer getIdVerificacionPendiente() {
        return idVerificacionPendiente;
    }

    public String getEstadoVerificacion() {
        return estadoVerificacion;
    }

    public void setEstadoVerificacion(String estadoVerificacion) {
        this.estadoVerificacion = estadoVerificacion;
    }

    public ClienteUsuario getClienteUsuario() {
        return clienteUsuario;
    }

    public void setClienteUsuario(ClienteUsuario clienteUsuario) {
        this.clienteUsuario = clienteUsuario;
    }

    public EstadoRut getEstadoRut() {
        return estadoRut;
    }

    public void setEstadoRut(EstadoRut estadoRut) {
        this.estadoRut = estadoRut;
    }
}
