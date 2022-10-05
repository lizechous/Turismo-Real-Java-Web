package com.duoc.turismo.service;

import com.duoc.turismo.repository.IComunaRepo;
import com.duoc.turismo.repository.IRegionRepo;
import com.duoc.turismo.repository.model.Comuna;
import com.duoc.turismo.repository.model.Region;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class MantenedorServiceImpl implements IMantenedorService{

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    IRegionRepo iRegionRepo;

    @Autowired
    IComunaRepo iComunaRepo;

    @Override
    public Boolean cargarRegionesComunas() {
        iComunaRepo.deleteAll();
        iRegionRepo.deleteAll();
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/comunas-regiones.json");
        try {
            HashMap<String, Object> hashJSON = objectMapper.readValue(inputStream,typeReference);
            List<HashMap<String, Object>> regiones = (List<HashMap<String, Object>>) hashJSON.get("regiones");
            for(HashMap region: regiones){
                Region regionModel = new Region();
                regionModel.setNombreRegion(region.get("region").toString());
                Region regionGuardada = iRegionRepo.save(regionModel);
                // casteo las comunas a un arreglo de strings
                List<String> comunas = (List<String>) region.get("comunas");
                for(String comuna: comunas){
                    Comuna comunaModel = new Comuna();
                    comunaModel.setNombreComuna(comuna);
                    comunaModel.setRegion(regionGuardada);
                    iComunaRepo.save(comunaModel);
                }
            }
        } catch (Exception e){
            System.out.println("Error al guardar regiones o comunas: "+e);
            return false;
        }
        return true;
    }

    @Override
    public List<Comuna> findByAllComunas(String region) {
        return iComunaRepo.getComunasPorRegion(region);
    }

    @Override
    public List<Region> findByAllRegion() {
        return iRegionRepo.findAll();
    }
}
