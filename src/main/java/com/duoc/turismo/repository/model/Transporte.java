package com.duoc.turismo.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSPORTE")
@PrimaryKeyJoinColumn(referencedColumnName = "id_servicio_extra_FK")
public class Transporte extends ServicioExtra{
    @Column(name = "modelo", nullable = false, length = 45)
    private String modelo;

    @Column(name = "marca", nullable = false, length = 45)
    private String marca;

    @Column(name = "capacidad_pasajeros", nullable = false)
    private String capacidadPasajeros;

    @Column(name = "patente", nullable = false, length = 8)
    private String patente;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(String capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
}
