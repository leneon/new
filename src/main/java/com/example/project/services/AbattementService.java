package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.dto.AbattementDTO;
import com.example.project.dto.AbattementParametreDTO;
import com.example.project.dto.ClientDTO;
import com.example.project.dto.ParametreDTO;
import com.example.project.entities.Abattement;
import com.example.project.entities.AbattementParametre;
import com.example.project.repositories.AbattementParametreRepository;
import com.example.project.repositories.AbattementRepository;

import java.text.Normalizer;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbattementService{

    private final AbattementRepository abattementRepository;
    private AbattementParametreRepository abattementParametreRepository;

    @Autowired
    public AbattementService(AbattementRepository abattementRepository, AbattementParametreRepository abattementParametreRepository) {
        this.abattementRepository = abattementRepository;
        this.abattementParametreRepository = abattementParametreRepository;
    }

    public List<Abattement> getAllAbattements() {
        return abattementRepository.findAll();
    }
       public List<AbattementDTO> getAllAbattementsDTO() {
        // return this.getAllAbattements();
        return this.getAllAbattements().stream()
                .map(this::mappedEntityToDTO)
                .collect(Collectors.toList());
    }

    public Abattement getAbattementById(Long id) {
        return abattementRepository.findById(id).orElse(null);
    }

    public Abattement createAbattement(Abattement abattement) {
        return abattementRepository.save(abattement);
    }

    public Abattement updateAbattement(Long id, Abattement abattement) {
        if (abattementRepository.existsById(id)) {
            abattement.setId(id);
            return abattementRepository.save(abattement);
        }
        return null;
    }

    public void deleteAbattement(Long id) {
        abattementRepository.deleteById(id);
    }

    /**
     * @param param
     * @return
     */
    public AbattementDTO mappedEntityToDTO(Abattement abattement){
        if(abattement==null)
            return null;
        AbattementDTO abattementDTO = new AbattementDTO();
        abattementDTO.setClient(new ClientDTO(abattement.getClient()));
        abattementDTO.setDate(abattement.getDate());
        abattementDTO.setId(abattement.getId());
        abattementDTO.setJournee(abattement.getJournee());
        abattementDTO.setVente(abattement.getVente());
        abattementDTO.setReg(abattement.getReg());
        abattementDTO.setNonReg(abattement.getNonReg());
        abattementDTO.setPaiement(abattement.getPaiement());
        abattementDTO.setSoldeaverser(abattement.getSoldeAVerser());
        abattementDTO.setTotal(abattement.getTotal());
        abattementDTO.setListeAbattementParametres(this.getListAbattementParametres(abattement.getId()));
        return abattementDTO;            
    }

    public List<AbattementParametreDTO> getListAbattementParametres(Long id) {
    return this.abattementParametreRepository.findByAbattement(id).stream()
                .map(this::mappedToDTO)
                .collect(Collectors.toList());
    }

    public AbattementParametreDTO mappedToDTO(AbattementParametre abattementParametre){
        if(abattementParametre==null)
            return null;
        return new AbattementParametreDTO(abattementParametre);
    }

    public String format(String str){
       return  Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
