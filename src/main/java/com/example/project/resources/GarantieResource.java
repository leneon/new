package com.example.project.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.project.dto.GarantieDTO;
import com.example.project.entities.Garantie;
import com.example.project.repositories.AgenceRepository;
import com.example.project.repositories.ClientRepository;
import com.example.project.services.GarantieService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/garanties")
public class GarantieResource {
    private  AgenceRepository agenceRepository;
    private  ClientRepository clientRepository;
    private GarantieService garantieService;

    @Autowired
    public GarantieResource(GarantieService garantieService,AgenceRepository agenceRepository,ClientRepository clientRepository) {
        this.garantieService = garantieService;
        this.agenceRepository = agenceRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Garantie> getGarantieById(@PathVariable Long id) {
        Garantie garantie = garantieService.getGarantieById(id);
        return ResponseEntity.ok(garantie);
    }

    @GetMapping
    public ResponseEntity<List<Garantie>> getAllGaranties() {
        List<Garantie> garanties = garantieService.getAllGaranties();
        return ResponseEntity.ok(garanties);
    }

    @PostMapping
    public ResponseEntity<Garantie> createGarantie(@RequestBody Garantie garantie) {
        Garantie createdGarantie = garantieService.createGarantie(garantie);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGarantie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGarantie(@PathVariable Long id) {
        garantieService.deleteGarantie(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/import")
    public List<GarantieDTO> importGaranties(@RequestBody List<GarantieDTO>garantieDTO) {
        List<Garantie> garanties = mappedEntity(garantieDTO);
        
        return garantieService.saveAll(garanties);
    }

    public List<Garantie> mappedEntity(List<GarantieDTO> garantieDTOs) {
        List<Garantie> garanties = new ArrayList<>();
        for (GarantieDTO garantieDTO : garantieDTOs) {
            System.out.println(garantieDTO.toString());
            // Garantie garantie = mapGarantieDTOToGarantie(garantieDTO);
            // garanties.add(garantie);
        }
        return garanties;
    }

     private Garantie mapGarantieDTOToGarantie(GarantieDTO garantieDTO) {
        System.out.println(garantieDTO.toString());
        Garantie garantie = new Garantie();
        garantie.setFromDate(garantieDTO.getFromDate());
        garantie.setToDate(garantieDTO.getToDate());
        garantie.setAgence(agenceRepository.findByCode(garantieDTO.getAgence()));
        garantie.setClient(clientRepository.findClient(garantieDTO.getClient()));
        garantie.setTotalSales(garantieDTO.getTotalSales());
        garantie.setCommissionOnSales(garantieDTO.getCommissionOnSales());
        garantie.setTotalPayements(garantieDTO.getTotalPayements());
        garantie.setCommissionOnPayements(garantieDTO.getCommissionOnPayements());
        garantie.setTotalPayements(garantieDTO.getTotalPayements());
        return garantie;
    }

}
