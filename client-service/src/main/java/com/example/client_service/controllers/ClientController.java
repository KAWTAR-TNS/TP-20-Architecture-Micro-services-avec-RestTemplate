package com.example.client_service.controllers;


import com.example.client_service.entities.Client;
import com.example.client_service.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")  // Préfixe de tous les endpoints de ce contrôleur
public class ClientController {

    @Autowired
    private ClientService service;


    @GetMapping
    public List<Client> findAll() {
        return service.findAll();
    }

    /**
     * Récupère un client par son ID
     * GET /api/client/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Client client = service.findById(id);
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erreur: " + e.getMessage());
        }
    }

    /**
     * Ajoute un nouveau client
     * POST /api/client
     */
    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Client savedClient = service.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }
}