package com.duoc.turismo.service;

import com.duoc.turismo.repository.IClienteUsuarioRepo;
import com.duoc.turismo.repository.model.ClienteUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteUsuarioImpl implements IClienteUsuarioService{
   @Autowired
   private IClienteUsuarioRepo iClienteUsuarioRepo;

    @Override
    public ClienteUsuario modificarDatosCliente(ClienteUsuario clienteModificado) {
        ClienteUsuario clienteActual = iClienteUsuarioRepo.getReferenceById(clienteModificado.getIdCliente());

        clienteActual.setEmailCliente(clienteModificado.getEmailCliente());
        clienteActual.setTelefonoCliente(clienteModificado.getTelefonoCliente());
        clienteActual.setNombreCliente(clienteModificado.getNombreCliente());
        return iClienteUsuarioRepo.save(clienteActual);

    }

    @Override
    public List<ClienteUsuario> listarClientes() {
        return iClienteUsuarioRepo.findAll();
    }

    @Override
    public ClienteUsuario BuscarClientesPorRut(String rutCLiente) {
        return iClienteUsuarioRepo.findByRutCliente(rutCLiente);
    }

    @Override
    public void eliminarCliente(ClienteUsuario clienteUsuario) {
         iClienteUsuarioRepo.delete(clienteUsuario);
    }

    @Override
    public void suspenderCuentaUsuario(Integer idUsuario) {
        ClienteUsuario clienteSuspender = iClienteUsuarioRepo.getReferenceById(idUsuario);
        clienteSuspender.setEstadoCuenta("SUSPENDIDA");
        iClienteUsuarioRepo.save(clienteSuspender);
    }
}
