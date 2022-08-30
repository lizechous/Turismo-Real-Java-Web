package com.duoc.turismo.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "MEDIO_DE_PAGO")
public class MedioDePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medio_de_pago", nullable = false)
    private Integer idMedioDePago;

    @Column(name = "tipo_tarjeta", nullable = false, length = 10)
    private String tipoTarjeta;

    @Column(name = "predeterminado", nullable = false)
    private Boolean predeterminado;

    @ManyToOne
    @JoinColumn(name = "id_cliente_FK")
    private ClienteUsuario clienteUsuario;

    public Integer getIdMedioDePago() {
        return idMedioDePago;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Boolean getPredeterminado() {
        return predeterminado;
    }

    public void setPredeterminado(Boolean predeterminado) {
        this.predeterminado = predeterminado;
    }

    public ClienteUsuario getClienteUsuario() {
        return clienteUsuario;
    }

}
