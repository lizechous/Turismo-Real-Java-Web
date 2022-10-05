package com.duoc.turismo.gateway;

import com.duoc.turismo.gateway.model.RutValidationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class RutGateway implements IRutGateway{
    @Autowired
    RestTemplate restTemplate;

    @Override
    public String rutValido(String rut) {

        /*
            el metodo exchange (en este caso) te pide los siguientes datos:
            - la url del servicio
            - el tipo de servicio
            - la clase a la cual se va a mapear la respuesta
         */
        HttpHeaders headers = new HttpHeaders();
        //Colección de tipo HashMap (clave-valor), el servicio pide verificar de donde viene la peticion
        //o si no manda error 403
        headers.add(HttpHeaders.USER_AGENT, "Application");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<RutValidationResponse> respuesta = restTemplate.exchange(
                "https://api.libreapi.cl/rut/activities?rut={rut}",
                HttpMethod.GET, //el Metodo http
                entity, //aqui le pasamos el agente
                RutValidationResponse.class, //la clase padre del servicio
                rut //el argumento
        );

        if(respuesta.getBody() != null &&
                respuesta.getBody().getData() != null &&
                !respuesta.getBody().getData().getName().isEmpty()){
            return respuesta.getBody().getData().getName();
        }
        return null; //NO RETORNA NADA YA QUE EL RUT NO SE VALIDÓ
    }
}
