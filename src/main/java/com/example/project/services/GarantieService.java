package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.project.entities.Agence;
import com.example.project.entities.Client;
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

    // @Transactional
    // public void importerGarantiesDepuisExcel(MultipartFile file) throws IOException {
    //     try {
    //         Workbook workbook = WorkbookFactory.create(file.getInputStream());
    //         Sheet sheet = workbook.getSheetAt(0);

    //         for (int i = 1; i <= sheet.getLastRowNum(); i++) {
    //             Row row = sheet.getRow(i);
    //             if (row != null) {
    //                 Garantie garantie = mapRowToGarantie(row);
    //                 garantieRepository.save(garantie);
    //             }
    //         }

    //         workbook.close();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    // private Garantie mapRowToGarantie(Row row) {
    //     Garantie garantie = new Garantie();
    //     garantie.setFromDate(row.getCell(0).getDateCellValue());
    //     garantie.setToDate(row.getCell(1).getDateCellValue());
    //     // Map other attributes accordingly based on your Excel file format
    //     return garantie;
    // }
}
