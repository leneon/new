package com.example.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.project.entities.AbattementParametre;

public interface AbattementParametreRepository extends JpaRepository<AbattementParametre, Long>   {
    @Query("SELECT ap FROM AbattementParametre ap WHERE ap.abattement.id = :idAbattement")
    public List<AbattementParametre> findByAbattement(Long idAbattement);

    // @Query("SELECT a FROM com.example.project.entities.Abattement a WHERE EXISTS (SELECT 1 FROM a.listabattementParametres ap WHERE ap.Abattement.id =:id)")
    // public AbattementParametre findAbattementParametreByAbattement(String id);

    @Query("SELECT p FROM AbattementParametre ap JOIN ap.abattement a  JOIN ap.parametre p  WHERE a.id = :idAbattement")
    public AbattementParametre findParametreByAbattement(Long idAbattement);
}
