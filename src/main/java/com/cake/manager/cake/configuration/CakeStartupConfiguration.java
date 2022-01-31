package com.cake.manager.cake.configuration;

import com.cake.manager.cake.domain.Cake;
import com.cake.manager.cake.repository.CakeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

/**
 * @author Oleh Kepsha
 */
@Configuration
@Slf4j
public class CakeStartupConfiguration {

    private final CakeRepository cakeRepository;
    private final String cakeUrl;

    public CakeStartupConfiguration(
            @Autowired CakeRepository cakeRepository,
            @Value("${cake.default.url}") String cakeUrl
    ) {
        this.cakeRepository = cakeRepository;
        this.cakeUrl = cakeUrl;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void initializeCakes(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> cakesResponse = restTemplate.getForEntity(cakeUrl, String.class);
        String responseBody = cakesResponse.getBody();
        if(responseBody !=  null) {
            try {
                Set<Cake> cakes = new ObjectMapper().readValue(responseBody, new TypeReference<>() {});
                cakeRepository.saveAll(cakes);
            } catch (JsonProcessingException e) {
                log.error("Unable to parse initial cakes payload");
                e.printStackTrace();
            }
        }
    }

}
