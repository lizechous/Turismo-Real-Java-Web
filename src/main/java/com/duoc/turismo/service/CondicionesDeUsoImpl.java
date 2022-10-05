package com.duoc.turismo.service;

import com.duoc.turismo.repository.ICondicionesDeUsoRepo;
import com.duoc.turismo.repository.IServicioDeptoRepo;
import com.duoc.turismo.repository.model.CondicionesDeUso;
import com.duoc.turismo.repository.model.ServicioDepto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicionesDeUsoImpl implements ICondicionesDeUsoService {

    @Autowired
    ICondicionesDeUsoRepo iCondicionesDeUsoRepo;


    @Override
    public void save(CondicionesDeUso condicionDeUsos) {
        iCondicionesDeUsoRepo.save(condicionDeUsos);
    }

    @Override
    public void deleteById(Integer idCondicionDeUso) {
        iCondicionesDeUsoRepo.deleteById(idCondicionDeUso);
    }

    @Override
    public List<CondicionesDeUso> listarAllCondiciones() {
        return iCondicionesDeUsoRepo.findAll();
    }

}