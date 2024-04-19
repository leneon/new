package com.example.project.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.project.entities.Agence;
import com.example.project.services.AgenceService;

import java.util.List;

@RestController
@RequestMapping("api/agences")
public class AgenceResource {

    private final AgenceService agenceService;
 
    @Autowired
    public AgenceResource(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @GetMapping
    public List<Agence> getAllAgences() {
        return agenceService.getAllAgences();
    }

    @GetMapping("/find/{id}")
    public Agence getAgenceById(@PathVariable Long id) {
        return agenceService.getAgenceById(id);
    }

    @PostMapping("/create")
    public Agence createAgence(@RequestBody Agence agence) {
        System.out.println("agence : "+agence);
        return agenceService.createAgence(agence);
    }

    @PutMapping("/update/{id}")
    public Agence updateAgence(@PathVariable Long id, @RequestBody Agence agence) {
        return agenceService.updateAgence(id, agence);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAgence(@PathVariable Long id) {
        agenceService.deleteAgence(id);
    }
}
