package com.duoc.turismo.repository.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "SERVICIO_EXTRA")
@Inheritance(strategy = InheritanceType.JOINED)
public class ServicioExtra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio_extra", nullable = false)
    protected Integer idServicioExtra;

    @Column(name = "region", nullable = false, length = 45)
    protected String region;

    @Column(name = "comuna", nullable = false, length = 45)
    protected String comuna;

    @Column(name = "persona_a_cargo", length = 45)
    protected String personaACargo;

    @Column(name = "estado", length = 45)
    protected Boolean estado;

    @OneToMany(mappedBy = "servicioExtra", cascade = CascadeType.ALL)
    private List<FotoTour> fotoTourList;

    public Integer getIdServicioExtra() {
        return idServicioExtra;
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

    public String getPersonaACargo() {
        return personaACargo;
    }

    public void setPersonaACargo(String personaACargo) {
        this.personaACargo = personaACargo;
    }

    public void setIdServicioExtra(Integer idServicioExtra) {
        this.idServicioExtra = idServicioExtra;
    }

    public List<FotoTour> getFotoTourList() {
        return fotoTourList;
    }

    public void setFotoTourList(List<FotoTour> fotoTourList) {
        this.fotoTourList = fotoTourList;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

