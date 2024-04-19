package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.dto.ParametreDTO;
import com.example.project.entities.Parametre;
import com.example.project.repositories.ParametreRepository;

import java.text.Normalizer;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParametreService {

    private final ParametreRepository parametreRepository;

    @Autowired
    public ParametreService(ParametreRepository parametreRepository) {
        this.parametreRepository = parametreRepository;
    }

    public List<Parametre> getAllParametres() {
        return parametreRepository.findAll();
    }
    public List<ParametreDTO> getAllParametresDTO() {
        return this.getAllParametres().stream()
                .map(this::mappedEntityToDTO)
                .collect(Collectors.toList());
    }

    public Parametre getParametreById(Long id) {
        return parametreRepository.findById(id).orElse(null);
    }

    public Parametre createParametre(Parametre parametre) {
        return parametreRepository.save(parametre);
    }

    public Parametre updateParametre(Long id, Parametre parametre) {
        if (parametreRepository.existsById(id)) {
            parametre.setId(id);
            return parametreRepository.save(parametre);
        }
        return null;
    }

    public void deleteParametre(Long id) {
        parametreRepository.deleteById(id);
    }

    /**
     * @param param
     * @return
     */
    public ParametreDTO mappedEntityToDTO(Parametre param){
        if(param==null)
            return null;
        ParametreDTO parametreDTO = new ParametreDTO();
        parametreDTO.setId(param.getId());
        parametreDTO.setSlug(this.format(param.getTitre().toLowerCase().replaceAll("\\s", "_")));
        parametreDTO.setTitre(param.getTitre());
        parametreDTO.setType(param.getType());
        parametreDTO.settaux(param.gettaux());

        return parametreDTO;            
    }

    public String format(String str){
       return  Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
