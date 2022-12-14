package com.duoc.turismo.repository;

import com.duoc.turismo.repository.model.CondicionesDeUso;
import com.duoc.turismo.repository.model.ServicioDepto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICondicionesDeUsoRepo extends JpaRepository<CondicionesDeUso, Integer> {
    //Eliminar CondicionDeUso
    void deleteById(Integer idCondicionDeUso);

    CondicionesDeUso findByIdCondicion(Integer idCondicionDeUso);

}
