package com.example.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.project.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


    @Query("SELECT c FROM com.example.project.entities.Client c WHERE c.numeroOp=:numeroOp")
    public Client findClient(String numeroOp);
    
}
