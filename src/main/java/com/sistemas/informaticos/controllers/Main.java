package com.sistemas.informaticos.controllers;

import com.sistemas.informaticos.models.Results;
import com.sistemas.informaticos.services.ElevationService;
import com.sistemas.informaticos.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    
    @Autowired
    ElevationService elevationService;


    @GetMapping("/")
    public String inicio() {
        return "Mi servidor backend examen utiliza /contar/{palabra} para mostrar cuantas A tiene y /elevacion/{lugar} para saber la elevacion en metros de un lugar";
    }
    
  @GetMapping("/contar/{palabra}")
    public String cuentaletras(@PathVariable String palabra) {
        return palabra + " tiene " + Utils.cuentaLetraA(palabra) + " letras A ";
    }

    @GetMapping("/elevacion/{lugar}")
    public String getElevation(@PathVariable String lugar){
        Results results = elevationService.getElevation(lugar);
        return results.results[0].elevation + " m";
    }
}
