package com.duoc.turismo.service;

import com.duoc.turismo.repository.model.ClienteUsuario;

import java.util.List;

public interface IClienteUsuarioService {

    void crearCuentaCLiente(ClienteUsuario clienteUsuario);
    ClienteUsuario modificarDatosCliente(ClienteUsuario clienteModificado);

    List<ClienteUsuario> listarClientes();

    ClienteUsuario BuscarClientesPorRut(String rutCLiente);

    void eliminarCliente(ClienteUsuario clienteUsuario);

    void suspenderCuentaUsuario(Integer idUsuario);
}
