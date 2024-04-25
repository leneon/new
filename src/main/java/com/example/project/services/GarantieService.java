package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.project.entities.Garantie;
import com.example.project.repositories.GarantieRepository;

@Service
public class GarantieService {

    private final GarantieRepository garantieRepository;

    @Autowired
    public GarantieService(GarantieRepository garantieRepository) {
        this.garantieRepository = garantieRepository;
    }

    public List<Garantie> getAllGaranties() {
        return garantieRepository.findAll();
    }

    public Garantie getGarantieById(Long id) {
        return garantieRepository.findById(id).orElse(null);
    }

    public Garantie createGarantie(Garantie garantie) {
        return garantieRepository.save(garantie);
    }

    public Garantie updateGarantie(Long id, Garantie garantie) {
        if (garantieRepository.existsById(id)) {
            garantie.setId(id);
            return garantieRepository.save(garantie);
        }
        return null;
    }

    public void deleteGarantie(Long id) {
        garantieRepository.deleteById(id);
    }

    public List<Garantie> listeGaranties() {
        return garantieRepository.findAll();
    }

    public List<Garantie> saveAll(List<Garantie> garanties) {
        return garantieRepository.saveAll(garanties);
    }

}
