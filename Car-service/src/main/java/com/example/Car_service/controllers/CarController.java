package com.example.Car_service.controllers;


import com.example.Car_service.models.CarResponse;
import com.example.Car_service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * Récupère toutes les voitures avec les détails des clients
     * GET /api/car
     */
    @GetMapping
    public List<CarResponse> findAll() {
        return carService.findAll();
    }

    /**
     * Récupère une voiture par son ID avec les détails du client
     * GET /api/car/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            CarResponse car = carService.findById(id);
            return ResponseEntity.ok(car);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erreur: " + e.getMessage());
        }
    }
}