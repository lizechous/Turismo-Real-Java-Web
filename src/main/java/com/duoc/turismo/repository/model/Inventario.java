package com.duoc.turismo.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "INVENTARIO")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario", nullable = false)
    private Integer idInventario;

    @Column(name = "fecha_inventario", nullable = false)
    private Date fechaInventario;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    private List<Elemento> elementoList;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_departamento_FK")
    private Departamento departamento;

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Date getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(Date fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Elemento> getElementoList() {
        return elementoList;
    }

    public void setElementoList(List<Elemento> elementoList) {
        this.elementoList = elementoList;
    }
}
