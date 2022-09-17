package com.duoc.turismo.service;

import com.duoc.turismo.controller.model.ImagenCarnetRequest;
import com.duoc.turismo.controller.model.RegistrarClienteRequest;
import com.duoc.turismo.repository.IClienteUsuarioRepo;
import com.duoc.turismo.repository.IFotoDeptoRepo;
import com.duoc.turismo.repository.IImagenCarnetRepo;
import com.duoc.turismo.repository.model.ClienteUsuario;
import com.duoc.turismo.repository.model.EstadoRut;
import com.duoc.turismo.repository.model.ImagenCarnet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

@Service
public class ClienteUsuarioImpl implements IClienteUsuarioService{
   @Autowired
   private IClienteUsuarioRepo iClienteUsuarioRepo;

   @Autowired
   private IImagenCarnetRepo iImagenCarnetRepo;

   //CREAR CUENTA CLIENTE USUARIO

    @Override
   public void crearCuentaCLiente(RegistrarClienteRequest clienteRequest) throws Exception {
        if (clienteRequest.getClienteUsuario().getEstadoRut().getIdEstadoRut() == 2 &&
                clienteRequest.getImagenCarnetRequestList().isEmpty()) {
            throw new Exception("Error al registrar, se requiere cargar fotos carnet");
        }

        //Se registra en la bds y se guarda en una variable para luego asignar el objeto cliente a las fotos
        ClienteUsuario clienteRegistrado = iClienteUsuarioRepo.save(clienteRequest.getClienteUsuario());
        //Se recorre el arreglo de fotos porque en el request viene mas de una
        for (ImagenCarnetRequest imagenCarnetRequest : clienteRequest.getImagenCarnetRequestList()) {
            //Se crea objeto vacío esta es el objeto que debe guardarse en la bds, no el imgRequest
            ImagenCarnet imgNueva = new ImagenCarnet();
            //se le setean los datos del imgRequest
            imgNueva.setTituloFotoCarnet(imagenCarnetRequest.getTituloFotoCarnet());
            imgNueva.setClienteUsuario(clienteRegistrado);
            //esto convierte la foto string en un byte (del postman viene en string)
            String fotoBase64 = imagenCarnetRequest.getFotoCarnet().split(",")[1];
            byte[] fotoByte = Base64.getDecoder().decode(fotoBase64);
            try {
                //aqui transforma el byte a BLOB
                imgNueva.setFotoCarnet(new SerialBlob(fotoByte));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            iImagenCarnetRepo.save(imgNueva);
        }


    }
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
    public void modificarEstadoCuentaCliente(Integer idUsuario, String estadoCuenta) {
        ClienteUsuario clienteSuspender = iClienteUsuarioRepo.getReferenceById(idUsuario);
        clienteSuspender.setEstadoCuenta(estadoCuenta);
        iClienteUsuarioRepo.save(clienteSuspender);
    }

    @Override
    public Integer updateEstadorutCliente(Integer estadoRutId, Integer idCliente) {
        ClienteUsuario clienteEstadoRut = iClienteUsuarioRepo.getReferenceById(idCliente);
        clienteEstadoRut.getEstadoRut().setIdEstadoRut(estadoRutId);
        Integer affectedRows = iClienteUsuarioRepo.updateEstadorutCliente(estadoRutId, idCliente);
        return  affectedRows;
    }
}
