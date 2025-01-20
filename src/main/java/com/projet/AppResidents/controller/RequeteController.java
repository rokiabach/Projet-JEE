package com.projet.AppResidents.controller;

import com.projet.AppResidents.dto.RequeteRequestDTO;
import com.projet.AppResidents.dto.RequeteResponseDTO;
import com.projet.AppResidents.service.RequeteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requetes")
public class RequeteController {

    @Autowired
    private RequeteService requeteService;

    // Créer une requête
    @PostMapping
    public ResponseEntity<RequeteResponseDTO> createRequete(@RequestBody RequeteRequestDTO requeteRequestDTO) {
        RequeteResponseDTO responseDTO = requeteService.createRequete(requeteRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Récupérer une requête par ID
    @GetMapping("/{id}")
    public ResponseEntity<RequeteResponseDTO> getRequeteById(@PathVariable Long id) {
        RequeteResponseDTO responseDTO = requeteService.getRequeteById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Récupérer toutes les requêtes
    @GetMapping
    public ResponseEntity<List<RequeteResponseDTO>> getAllRequetes() {
        List<RequeteResponseDTO> responseDTOs = requeteService.getAllRequetes();
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    // Mettre à jour une requête
    @PutMapping("/{id}")
    public ResponseEntity<RequeteResponseDTO> updateRequete(
            @PathVariable Long id, @RequestBody RequeteRequestDTO requeteRequestDTO) {
        RequeteResponseDTO responseDTO = requeteService.updateRequete(id, requeteRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Supprimer une requête
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequete(@PathVariable Long id) {
        requeteService.deleteRequete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}