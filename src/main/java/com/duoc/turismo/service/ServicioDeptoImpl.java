package com.duoc.turismo.service;

import com.duoc.turismo.repository.IServicioDeptoRepo;
import com.duoc.turismo.repository.model.ServicioDepto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioDeptoImpl implements IServicioDeptoService {

    @Autowired
    IServicioDeptoRepo iServicioDeptoRepo;

    //Guardar lista servicios
    @Override
    public void save(ServicioDepto servicioDepto) {
        iServicioDeptoRepo.save(servicioDepto);
    }

    @Override
    public List<ServicioDepto> findAll() {
        return iServicioDeptoRepo.findAll();
    }

    @Override
    public ServicioDepto updateServicioDepto(String tipoServicioDepto, Integer idServicioDepto) {
        return iServicioDeptoRepo.updateServicioDepto(tipoServicioDepto, idServicioDepto);
    }

    @Override
    public void deleteById(Integer idServicioDepto) {
        ServicioDepto servicioDepto = iServicioDeptoRepo.getReferenceById(idServicioDepto);
            iServicioDeptoRepo.deleteById(servicioDepto.getIdServicioDepto());
    }
}