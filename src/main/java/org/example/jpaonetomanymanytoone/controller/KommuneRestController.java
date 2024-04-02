package org.example.jpaonetomanymanytoone.controller;

import org.example.jpaonetomanymanytoone.model.Kommune;
import org.example.jpaonetomanymanytoone.model.Region;
import org.example.jpaonetomanymanytoone.repositories.KommuneRepository;
import org.example.jpaonetomanymanytoone.service.ApiServiceGetKommuner;
import org.example.jpaonetomanymanytoone.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KommuneRestController {

    @Autowired
    KommuneRepository kommuneRepository;

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    //Endpoint der henter data fra rest-api og lægger ned i egen database
    @GetMapping("/getkommuner")
    public List<Kommune> getKommuner() {
        List<Kommune> lstKommuner = apiServiceGetKommuner.getKommuner();
        return lstKommuner;
    }

    // endpoint til egen database
    @GetMapping("/kommuner")
    public List<Kommune> listKommuner() {
    return kommuneRepository.findAll();
    }

    @PostMapping("/kommuner")
    @ResponseStatus(HttpStatus.CREATED)
    public Kommune postKommune(@RequestBody Kommune kommune) {
        try {
            System.out.println(kommune);
            return kommuneRepository.save(kommune);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return kommune;
        }
    }

}
