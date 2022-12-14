package com.duoc.turismo.service;

import com.duoc.turismo.repository.model.CondicionesDeUso;
import com.duoc.turismo.repository.model.ServicioDepto;

import java.util.List;

public interface ICondicionesDeUsoService {

    public void save(CondicionesDeUso condicionDeUsos);

    void deleteById(Integer idCondicionDeUso);

    List<CondicionesDeUso> listarAllCondiciones();
}
