package com.example.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.project.dto.ParametreDTO;
import com.example.project.entities.Parametre;
import com.example.project.services.ParametreService;

import java.util.List;

@RestController
@RequestMapping("api/parametres")
public class ParametreResource {

    private final ParametreService parametreService;

    @Autowired
    public ParametreResource(ParametreService parametreService) {
        this.parametreService = parametreService;
    }

    @GetMapping
    public List<ParametreDTO> getAllParametres() {
        return parametreService.getAllParametresDTO();
    }

    @GetMapping("/find/{id}")
    public Parametre getParametreById(@PathVariable Long id) {
        return parametreService.getParametreById(id);
    }

    @PostMapping("/create")
    public Parametre createParametre(@RequestBody Parametre parametre) {
        return parametreService.createParametre(parametre);
    }

    @PutMapping("/update/{id}")
    public Parametre updateParametre(@PathVariable Long id, @RequestBody Parametre parametre) {
        return parametreService.updateParametre(id, parametre);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteParametre(@PathVariable Long id) {
        parametreService.deleteParametre(id);
    }
}
