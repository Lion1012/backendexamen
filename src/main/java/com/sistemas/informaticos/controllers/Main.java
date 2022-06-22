package com.sistemas.informaticos.controllers;

import com.sistemas.informaticos.models.Results;
import com.sistemas.informaticos.services.PopulationService;
import com.sistemas.informaticos.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    
    @Autowired
    PopulationService elevationService;


    @GetMapping("/")
    public String inicio() {
        return "Mi servidor backend examen";
    }
    
    @GetMapping("/coincidencias")
    public String concideLetras(@RequestParam String nombre1, @RequestParam String nombre2) {
        return nombre1 + nombre2 + " tienen " + Utils.calculaCoincidencias(nombre1, nombre2) + " letras en comun";
    }
    
    @GetMapping("/elevacion/{lugar}")
    public String getElevation(@PathVariable String elevacion){
        Results results = elevationService.getPopulation(elevacion);
        return results.results[0].elevation + " m";
    }
}
