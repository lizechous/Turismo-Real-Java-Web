package com.duoc.turismo.repository.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "REGION")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_region", nullable = false)
    private String idRegion;

    @Column(name = "nombre_comuna", nullable = false, length = 45)
    private String nombrecomuna;

    @OneToMany(mappedBy = "region")
    private List<Comuna> comunaList;

    public String getIdRegion() {
        return idRegion;
    }

    public String getNombrecomuna() {
        return nombrecomuna;
    }

    public void setNombrecomuna(String nombrecomuna) {
        this.nombrecomuna = nombrecomuna;
    }

    public List<Comuna> getComunaList() {
        return comunaList;
    }

    public void setComunaList(List<Comuna> comunaList) {
        this.comunaList = comunaList;
    }
}
