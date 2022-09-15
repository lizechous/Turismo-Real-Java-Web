package com.duoc.turismo.service;

import com.duoc.turismo.controller.model.RegistrarClienteRequest;
import com.duoc.turismo.repository.model.ClienteUsuario;
import com.duoc.turismo.repository.model.EstadoRut;

import java.util.List;

public interface IClienteUsuarioService {

    void crearCuentaCLiente(RegistrarClienteRequest clienteRequest) throws Exception;
    ClienteUsuario modificarDatosCliente(ClienteUsuario clienteModificado);

    List<ClienteUsuario> listarClientes();

    ClienteUsuario BuscarClientesPorRut(String rutCLiente);

    void eliminarCliente(ClienteUsuario clienteUsuario);

    void modificarEstadoCuentaCliente(Integer idUsuario, String estadoCuenta);

    Integer updateEstadorutCliente(Integer estadoRutId, Integer idCliente);
}
