package com.duoc.turismo.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "ELEMENTO")
public class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_elemento", nullable = false)
    private Integer idElemento;

    @Column(name = "nombre_elemento", nullable = false, length = 45)
    private String nombreElemento;

    @Column(name = "valor_elemento", nullable = false)
    private Integer valorElemento;

    @Column(name = "cantidad_elemento", nullable = false)
    private Integer cantidadElemento;

    @ManyToOne
    @JoinColumn(name = "id_inventario_FK")
    private Inventario inventario;

    public Integer getIdElemento() {
        return idElemento;
    }

    public String getNombreElemento() {
        return nombreElemento;
    }

    public void setNombreElemento(String nombreElemento) {
        this.nombreElemento = nombreElemento;
    }

    public Integer getValorElemento() {
        return valorElemento;
    }

    public void setValorElemento(Integer valorElemento) {
        this.valorElemento = valorElemento;
    }

    public Integer getCantidadElemento() {
        return cantidadElemento;
    }

    public void setCantidadElemento(Integer cantidadElemento) {
        this.cantidadElemento = cantidadElemento;
    }

    public Inventario getInventario() {
        return inventario;
    }

}
