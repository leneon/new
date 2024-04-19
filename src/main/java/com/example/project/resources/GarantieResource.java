package com.example.project.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.project.entities.Garantie;
import com.example.project.services.GarantieService;

import java.util.List;

@RestController
@RequestMapping("/api/garanties")
public class GarantieResource {

    @Autowired
    private GarantieService garantieService;

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
}
