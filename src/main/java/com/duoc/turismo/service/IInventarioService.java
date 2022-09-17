package com.duoc.turismo.service;

import com.duoc.turismo.repository.model.Inventario;

public interface IInventarioService {

    void save(Inventario inventario);

    Inventario getReferenceById(Integer id);
}
