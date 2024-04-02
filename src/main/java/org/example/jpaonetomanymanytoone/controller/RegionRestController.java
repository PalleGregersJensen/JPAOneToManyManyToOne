package org.example.jpaonetomanymanytoone.controller;

import org.example.jpaonetomanymanytoone.model.Kommune;
import org.example.jpaonetomanymanytoone.model.Region;
import org.example.jpaonetomanymanytoone.repositories.RegionRepository;
import org.example.jpaonetomanymanytoone.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class RegionRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @Autowired
    RegionRepository regionRepository;

    //Endpoint to rest api
    @GetMapping("/getregioner")
    public List<Region> getRegioner() {
        List<Region> lstRegioner = apiServiceGetRegioner.getRegioner();
        return lstRegioner;
    }

    // Endpoint to own database
    @GetMapping("/regioner")
    public List<Region> listRegioner() {
        return regionRepository.findAll();
    }

    //Get region via kode(=id)
    @GetMapping("region/{kode}")
    public ResponseEntity<Region> region(@PathVariable String kode) {
        Region region =  regionRepository.findById(kode).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "kode=" + kode + " NOT-FOUND"));
        return ResponseEntity.ok(region);
    }


    //Create new region in region-database
    //@PostMapping("/regioner")
    //@ResponseStatus(HttpStatus.CREATED)
    //public Region postRegion(@RequestBody Region region) {
    //    System.out.println(region);
    //    return regionRepository.save(region);
    //}


    @PostMapping("/region")
    public ResponseEntity<Region> postRegion(@RequestBody Region region) {
        regionRepository.save(region);
        return new ResponseEntity<>(region, HttpStatus.CREATED);
    }

}
