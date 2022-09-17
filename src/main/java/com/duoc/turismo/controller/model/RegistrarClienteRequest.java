package com.duoc.turismo.controller.model;

import com.duoc.turismo.repository.model.ClienteUsuario;

import java.util.List;

public class RegistrarClienteRequest {

    private ClienteUsuario clienteUsuario;

    private List<ImagenCarnetRequest> imagenCarnetRequestList;

    public ClienteUsuario getClienteUsuario() {
        return clienteUsuario;
    }

    public void setClienteUsuario(ClienteUsuario clienteUsuario) {
        this.clienteUsuario = clienteUsuario;
    }

    public List<ImagenCarnetRequest> getImagenCarnetRequestList() {
        return imagenCarnetRequestList;
    }

    public void setImagenCarnetRequestList(List<ImagenCarnetRequest> imagenCarnetRequestList) {
        this.imagenCarnetRequestList = imagenCarnetRequestList;
    }
}
