package com.example.client_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  // Marque cette classe comme une entité JPA
@Data    // Génère getters, setters, toString, equals, hashCode
@NoArgsConstructor  // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
public class Client {

    @Id  // Marque ce champ comme clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incrémentation
    private Long id;

    private String nom;  // Nom du client
    private Float age;   // Âge du client

    // Lombok génère automatiquement les getters, setters, constructeurs, etc.
}