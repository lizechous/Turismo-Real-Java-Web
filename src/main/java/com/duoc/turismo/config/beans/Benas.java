package com.duoc.turismo.config.beans;

import com.duoc.turismo.repository.model.ServicioExtra;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class Benas {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ServicioExtra objetoServicioExtra() {
        return new ServicioExtra(){};
    }
}
