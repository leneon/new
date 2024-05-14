package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.project.entities.Garantie;

public interface GarantieRepository extends JpaRepository<Garantie, Long>   {
     

}
