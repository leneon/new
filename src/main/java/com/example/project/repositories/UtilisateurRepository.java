package com.example.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entities.Utilisateur;
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    /**
     * @param email
     * @return
     */
    public Utilisateur findByEmail(String email);
    
}
