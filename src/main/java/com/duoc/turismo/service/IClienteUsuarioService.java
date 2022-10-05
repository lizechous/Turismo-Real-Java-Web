package com.duoc.turismo.service;

import com.duoc.turismo.controller.model.RegistrarClienteRequest;
import com.duoc.turismo.repository.model.ClienteUsuario;
import com.duoc.turismo.repository.model.EstadoRut;

import java.util.List;

public interface IClienteUsuarioService {

    ClienteUsuario crearCuentaCLiente(RegistrarClienteRequest clienteRequest) throws Exception;
    ClienteUsuario modificarDatosCliente(ClienteUsuario clienteModificado);

    List<ClienteUsuario> listarClientes();

    ClienteUsuario buscarPorId(Integer id);

    List<ClienteUsuario> buscarClientes(String rutCLiente, String estadoCuenta, Integer estadoRut);

    ClienteUsuario buscarPorRut(String rutCLiente);

    void eliminarCliente(ClienteUsuario clienteUsuario);

    void modificarEstadoCuentaCliente(Integer idUsuario, String estadoCuenta);

    Integer updateEstadorutCliente(Integer estadoRutId, Integer idCliente);

    ClienteUsuario loginUser(String email, String password);
}
