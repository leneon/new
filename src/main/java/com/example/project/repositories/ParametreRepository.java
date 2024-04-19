package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entities.Parametre;

public interface ParametreRepository extends JpaRepository<Parametre, Long>  {
    
}
