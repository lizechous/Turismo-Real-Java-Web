package com.duoc.turismo.service;

import com.duoc.turismo.config.exceptions.ServicioExtraException;
import com.duoc.turismo.repository.IFotoTourRepo;
import com.duoc.turismo.repository.ISolicitudServicioExtraRepo;
import com.duoc.turismo.repository.ITourRepo;
import com.duoc.turismo.repository.ITransporteRepo;
import com.duoc.turismo.repository.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioExtraImpl implements IServicioExtraService {

    @Autowired
    ITourRepo iTourRepo;

    @Autowired
    ITransporteRepo iTransporteRepo;

    @Autowired
    IFotoTourRepo iFotoTourRepo;

    @Autowired
    ISolicitudServicioExtraRepo solicitudServicioExtraRepo;

    //CREAR TOUR
    @Override
    public Boolean saveTour(Tour tour) throws ServicioExtraException {
        try{
            Tour tourSinFotos = (Tour) tour.clone();
            tourSinFotos.setFotoTourList(null);
            Tour tourGuardado = iTourRepo.save(tourSinFotos);

            for(FotoTour foto: tour.getFotoTourList()){
                String fotoBase64 = foto.getFotoTourString().split(",")[1];
                byte[] fotoByte = Base64.getDecoder().decode(fotoBase64);
                try {
                    foto.setFotoTour(new SerialBlob(fotoByte));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                foto.setServicioExtra(tourGuardado);
                iFotoTourRepo.save(foto);
            }
            return true;
        }catch (Exception e){
            throw new ServicioExtraException("Error al crear servicio tour");
        }
    }

    //CREAR TRANSPORTE
    @Override
    public Boolean saveTransporte(Transporte transporte) throws ServicioExtraException {
        try {
            iTransporteRepo.save(transporte);
            return true;
        }catch (Exception e){
            throw new ServicioExtraException("Error al crear servicio transporte");
        }
    }

    @Override
    //LISTAR TODOS LOS TOUR
    public List<Tour> listarTours() throws ServicioExtraException {

        try{
            return iTourRepo.findByEstado(true);
        }catch (Exception e){
            throw new ServicioExtraException("Error al listar los tour");
        }
    }

    @Override
    //LISTAR TODOS LOS TRANSPORTES
    public List<Transporte> listarTransportes() throws ServicioExtraException {

        try {
            return iTransporteRepo.findByEstado(true);
        }catch (Exception e){
            throw new ServicioExtraException("Error al listar transportes");
        }
    }

    @Override
    public List<Tour> findByRegionAndComunaTour(String region, String comuna) throws ServicioExtraException {
        try{
            return iTourRepo.findByRegionAndComunaAndEstado(region,comuna,true);
        }catch (Exception e){
            throw new ServicioExtraException("Error al buscar tour");
        }
    }

    @Override
    public List<Transporte> findByRegionAndComunaTransporte(String region, String comuna, Integer personas) throws ServicioExtraException {
        try{
            List<Transporte> lista = iTransporteRepo.findByRegionAndComunaAndEstado(region, comuna, true);
            return personas == null ? lista : lista.stream().filter(t -> Integer.parseInt(t.getCapacidadPasajeros()) >= personas).collect(Collectors.toList());
        }catch (Exception e){
            throw new ServicioExtraException("Error al buscar transporte");
        }
    }

    //ELIMINAR TOUR
    @Override
    public Boolean cambiarEstadoTour(Integer idTour, Boolean estado) throws ServicioExtraException {

        try{
            Tour tour = iTourRepo.findByIdServicioExtra(idTour);
            tour.setEstado(estado);
            iTourRepo.save(tour);
            return true;
        }catch (Exception e){
            throw new ServicioExtraException("Error al eliminar tour");
        }
    }

    //ELIMINAR TRANSPORTE
    @Override
    public Boolean cambiarEstadoTransporte(Integer idTransporte, Boolean estado) throws ServicioExtraException {
        try{
            Transporte transporte = iTransporteRepo.findByIdServicioExtra(idTransporte);
            transporte.setEstado(estado);
            iTransporteRepo.save(transporte);
            return true;
        }catch (Exception e){
            throw new ServicioExtraException("Error al eliminar transporte");
        }
    }

    //Actualizar tour
    @Override
    public Tour actualizarTour(Tour tourNuevo) throws ServicioExtraException {
        Tour tourActual = iTourRepo.getReferenceById(tourNuevo.getIdServicioExtra());
        tourActual.setDescripcionTour(tourNuevo.getDescripcionTour());
        tourActual.setTituloTour(tourNuevo.getTituloTour());
        tourActual.setCantidadPersonasMax(tourNuevo.getCantidadPersonasMax());
        tourActual.setRegion(tourNuevo.getRegion());
        tourActual.setComuna(tourNuevo.getComuna());
        tourActual.setPersonaACargo(tourNuevo.getPersonaACargo());
      try{
          return iTourRepo.save(tourActual);
      }catch (Exception e){
          throw new ServicioExtraException("Error al actualizar tour");
      }
    }

    //Actualizar transporte
    @Override
    public Transporte actualizarTransporte(Transporte transporteNuevo) throws ServicioExtraException {
        Transporte transporteActual = iTransporteRepo.getReferenceById(transporteNuevo.getIdServicioExtra());
        transporteActual.setPersonaACargo(transporteNuevo.getPersonaACargo());
        transporteActual.setRegion(transporteNuevo.getRegion());
        transporteActual.setComuna(transporteNuevo.getComuna());
        transporteActual.setMarca(transporteNuevo.getMarca());
        transporteActual.setModelo(transporteNuevo.getModelo());
        transporteActual.setCapacidadPasajeros(transporteNuevo.getCapacidadPasajeros());
        transporteActual.setPatente(transporteNuevo.getPatente());
        try{
            return iTransporteRepo.save(transporteActual);
        }catch (Exception e){
            throw new ServicioExtraException("Error al actualizar transporte");
        }
    }

    @Override
    public List<String> getRegionesTour() {
        return iTourRepo.getRegionesTour();
    }

    @Override
    public List<String> getRegionesTransporte() throws ServicioExtraException {
        return iTransporteRepo.getRegionesTransporte();
    }

    @Override
    public List<String> getComunasTour(String region) throws ServicioExtraException {
        return iTourRepo.getComunasTour(region);
    }

    @Override
    public List<String> getComunasTransporte(String region) throws ServicioExtraException {
        return iTransporteRepo.getComunasTransporte(region);
    }

    @Override
    public Tour buscarTourPorId(Integer id) throws ServicioExtraException {
        return iTourRepo.findByIdServicioExtra(id);
    }

    @Override
    public Transporte buscarTransportePorId(Integer id) throws ServicioExtraException {
        return iTransporteRepo.findByIdServicioExtra(id);
    }

    @Override
    public void actualizarFotos(Tour tour) throws ServicioExtraException {
        //obtengo el id del depto para asignarselo a las nuevas fotos
        Tour tourGuardado = iTourRepo.findByIdServicioExtra(tour.getIdServicioExtra());
        for(FotoTour fotoRequest: tour.getFotoTourList()){ //fotoDeptorequestList***
            if(fotoRequest.getAccion() == null){
                continue;
            }
            switch (fotoRequest.getAccion()){
                case AGREGAR:
                    FotoTour fotoEntityNueva = new FotoTour();
                    fotoEntityNueva.setServicioExtra(tourGuardado);
                    fotoEntityNueva.setTituloFotoTour(fotoRequest.getTituloFotoTour());
                    String fotoBase64 = fotoRequest.getFotoTourString().split(",")[1];
                    byte[] fotoByte = Base64.getDecoder().decode(fotoBase64);
                    try {
                        fotoEntityNueva.setFotoTour(new SerialBlob(fotoByte));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    iFotoTourRepo.save(fotoEntityNueva);
                    break;
                case ELIMINAR:
                    iFotoTourRepo.deleteById(fotoRequest.getIdFotoTour());
                    break;
            }

        }
    }

    @Override
    public List<SolicitudServicioExtra> buscarSolicitudes() {
        return solicitudServicioExtraRepo.buscarSolicitudes();
    }

    @Override
    public List<SolicitudServicioExtra> buscarSolicitudesCliente(Integer idCliente) {
        return solicitudServicioExtraRepo.buscarSolicitudesCliente(idCliente);
    }

    @Override
    public void planificarServicio(SolicitudServicioExtra solicitud) {
        Reserva reserva = new Reserva();
        reserva.setIdReserva(solicitud.getIdReserva());
        solicitud.setReserva(reserva);
        solicitudServicioExtraRepo.save(solicitud);
    }

    @Override
    public SolicitudServicioExtra buscarSolicitud(Integer id) {
        return solicitudServicioExtraRepo.findByIdSolicitud(id);
    }

}
