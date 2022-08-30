package com.duoc.turismo.repository.model;

import javax.persistence.*;

@Entity
@Table(name="USUARIO_SISTEMA")
public class UsuarioSistema {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_usuario",nullable = false)
    private Integer idUsuario;

    @Column(name = "tipo_usuario", nullable = false, length = 15)
    private String tipoUsuario;

    @Column(name = "nombre_usuario", nullable = false, length = 45)
    private String nombreUsuario;

    @Column(name = "password_usuario", nullable = false, length = 80)
    private String passwordUsuario;

    @Column(name = "email_usuario", nullable = false, length = 45)
    private String emailUsuario;

    @Column(name = "telefono_usuario", nullable = false, length = 12)
    private String telefonoUsuario;

    @Column(name = "rut_usuario", nullable = false, length = 12)
    private String rutUsuario;



    public Integer getIdUsuario() {
        return idUsuario;
    }


    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }
}
