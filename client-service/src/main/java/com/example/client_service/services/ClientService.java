package com.example.client_service.services;

import com.example.client_service.entities.Client;
import com.example.client_service.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Marque cette classe comme un composant Service
public class ClientService {

    @Autowired  // Injection de dépendance
    private ClientRepository clientRepository;

    /**
     * Récupère tous les clients de la base de données
     * @return Liste de tous les clients
     */
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    /**
     * Récupère un client par son identifiant
     * @param id Identifiant du client
     * @return Le client correspondant
     * @throws Exception Si aucun client n'est trouvé avec cet ID
     */
    public Client findById(Long id) throws Exception {
        return clientRepository.findById(id)
                .orElseThrow(() -> new Exception("Client non trouvé avec l'ID: " + id));
    }

    /**
     * Ajoute un nouveau client ou met à jour un client existant
     * @param client Le client à sauvegarder
     * @return Le client sauvegardé avec son ID généré
     */
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    // Vous pouvez ajouter d'autres méthodes métier ici
}