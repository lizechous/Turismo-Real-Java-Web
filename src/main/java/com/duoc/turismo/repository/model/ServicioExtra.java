package com.duoc.turismo.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "SERVICIO_EXTRA")
@Inheritance(strategy = InheritanceType.JOINED)
public class ServicioExtra {
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
}
