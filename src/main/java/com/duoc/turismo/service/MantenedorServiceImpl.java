package com.duoc.turismo.service;

import com.duoc.turismo.repository.IComunaRepo;
import com.duoc.turismo.repository.IFotoMantencionRepo;
import com.duoc.turismo.repository.IMantencionRepo;
import com.duoc.turismo.repository.IRegionRepo;
import com.duoc.turismo.repository.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

@Service
public class MantenedorServiceImpl implements IMantenedorService{

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    IRegionRepo iRegionRepo;

    @Autowired
    IComunaRepo iComunaRepo;

    @Autowired
    IFotoMantencionRepo fotoMantencionRepo;

    @Autowired
    IMantencionRepo mantencionRepo;

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

    @Override
    public void crearMantencion(Mantencion mantencion) {
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(mantencion.getIdDepartamento());

        mantencion.setDepartamento(departamento);

        List<FotoMantencion> fotosRespaldo = mantencion.getFotoMantencionList();
        mantencion.setFotoMantencionList(null);

        Mantencion mantencionGuardada = mantencionRepo.save(mantencion);

        for (FotoMantencion fotoMantencion: fotosRespaldo){
            String fotoBase64 = fotoMantencion.getFotoMantencionString().split(",")[1];
            byte[] fotoByte = Base64.getDecoder().decode(fotoBase64);
            try {
                fotoMantencion.setFotoMantencion(new SerialBlob(fotoByte));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            fotoMantencion.setMantencion(mantencionGuardada);
            fotoMantencionRepo.save(fotoMantencion);
        }
    }

    @Override
    public List<Mantencion> buscarMantencionesDepto(Integer id) {
        return mantencionRepo.buscarMantencionesDepto(id);
    }

    @Override
    public Mantencion buscarMantencionId(Integer id) {
        return mantencionRepo.findByIdMantencion(id);
    }

    @Override
    public void modificarFotosMantencion(Mantencion mantencion) {

        for(FotoMantencion foto: mantencion.getFotoMantencionList()){ //fotoDeptorequestList***
            if(foto.getAccion() == null){
                continue;
            }
            switch (foto.getAccion()){
                case AGREGAR:
                    FotoMantencion fotoEntityNueva = new FotoMantencion();
                    fotoEntityNueva.setMantencion(mantencion);
                    fotoEntityNueva.setTituloFoto(foto.getTituloFoto());
                    String fotoBase64 = foto.getFotoMantencionString().split(",")[1];
                    byte[] fotoByte = Base64.getDecoder().decode(fotoBase64);
                    try {
                        fotoEntityNueva.setFotoMantencion(new SerialBlob(fotoByte));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    fotoMantencionRepo.save(fotoEntityNueva);
                    break;
                case ELIMINAR:
                    fotoMantencionRepo.deleteById(foto.getIdFotoMatencion());
                    break;
            }

        }
    }

    @Override
    public void modificarMantencion(Mantencion mantencion) {
        Mantencion mantencionGuardada = mantencionRepo.getReferenceById(mantencion.getIdMantencion());
        mantencionGuardada.setEstado(mantencion.getEstado());
        mantencionGuardada.setDescripcion(mantencion.getDescripcion());
        mantencionGuardada.setFechaInicio(mantencion.getFechaInicio());
        mantencionGuardada.setFechaTermino(mantencion.getFechaTermino());
        mantencionGuardada.setTitulo(mantencion.getTitulo());
        mantencionGuardada.setPresupuesto(mantencion.getPresupuesto());
        mantencionRepo.save(mantencionGuardada);
    }
}
