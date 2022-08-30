package com.duoc.turismo.repository.model;

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

    @OneToOne
    @JoinColumn(name = "id_departamento_FK")
    private Departamento departamento;

    public Integer getIdInventario() {
        return idInventario;
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
}
