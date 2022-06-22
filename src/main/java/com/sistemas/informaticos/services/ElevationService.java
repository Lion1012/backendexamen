package com.sistemas.informaticos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sistemas.informaticos.models.Results;

@Service
public class ElevationService {

        
        @Autowired
        RestTemplate restTemplate;
    
        public Results getElevation(String lugar){
            String url = "https://geocoding-api.open-meteo.com/v1/search?name="+lugar;
            Results elevation = restTemplate.getForObject(url, Results.class);
            return elevation;
        }
    }