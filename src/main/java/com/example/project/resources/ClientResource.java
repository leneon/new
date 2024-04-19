package com.example.project.resources;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.dto.ClientDTO;
import com.example.project.entities.Client;
import com.example.project.repositories.AgenceRepository;
import com.example.project.services.ClientService;

@RestController
@RequestMapping("api/clients")
public class ClientResource {

    private final ClientService clientService;
    private final AgenceRepository agenceRepository;
 
    @Autowired
    public ClientResource(ClientService clientService,AgenceRepository agenceRepository) {
        this.clientService = clientService;
        this.agenceRepository = agenceRepository;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/find/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/create")
    public Client createClient(@RequestBody Client client) {
        System.out.println("client : " + client);
        return clientService.createClient(client);
    }

    @PutMapping("/update/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @PostMapping("/import")
    public List<Client> importClient(@RequestBody List<ClientDTO> clientDTOs) {
        List<Client> clients = mappedEntity(clientDTOs);
        
        return clientService.saveAll(clients);
    }

    public List<Client> mappedEntity(List<ClientDTO> clientDTOs) {
        List<Client> clients = new ArrayList<>();
        for (ClientDTO clientDTO : clientDTOs) {
            Client client = mapClientDTOToClient(clientDTO); // Méthode pour mapper un ClientDTO à un Client
            // System.out.println(client.toString());
            clients.add(client);
        }
        return clients;
    }

     // Méthode pour mapper un ClientDTO à un Client
     private Client mapClientDTOToClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setNumeroOp(clientDTO.getNumeroOp());
        client.setAgence(agenceRepository.findByCode(clientDTO.getAgence()));
        client.setBanque(clientDTO.getBanque());
        client.setCaisse(clientDTO.getCaisse());
        client.setLocalite(clientDTO.getLocalite());
        client.setZone(clientDTO.getZone());
        client.setDatecreation(new Date());
        return client;
    }



}
