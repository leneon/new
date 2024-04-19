package com.example.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.dto.AgenceDTO;
import com.example.project.entities.Agence;
import com.example.project.repositories.AgenceRepository;

@Service
public class AgenceService {

    private final AgenceRepository agenceRepository;

    @Autowired
    public AgenceService(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }

    public Agence getAgenceById(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    public Agence createAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    public Agence updateAgence(Long id, Agence agence) {
        if (agenceRepository.existsById(id)) {
            agence.setId(id);
            return agenceRepository.save(agence);
        }
        return null;
    }

    public void deleteAgence(Long id) {
        agenceRepository.deleteById(id);
    }

    public List<AgenceDTO> listeAgences() {
        List<AgenceDTO> agenceDTOList = new ArrayList<>();
    
        this.agenceRepository.findAll().forEach(agence -> {
            agenceDTOList.add(mappedEntityToDTO(agence));
        });
    
        return agenceDTOList;
    }
    
    

    public AgenceDTO mappedEntityToDTO(Agence agence){
        if(agence==null)
            return null;

        AgenceDTO  agenceDTO = new AgenceDTO();

        agenceDTO.setId(agence.getId());
        agenceDTO.setNom(agence.getNom());
        agenceDTO.setAdresse(agence.getAdresse());
        agenceDTO.setVille(agence.getVille());
        agenceDTO.setLocalisation(agence.getLocalisation());

        return agenceDTO;
    }



}
