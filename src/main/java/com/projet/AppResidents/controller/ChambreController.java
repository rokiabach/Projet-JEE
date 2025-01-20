package com.projet.AppResidents.controller;

import com.projet.AppResidents.dto.ChambreRequestDTO;
import com.projet.AppResidents.dto.ChambreResponseDTO;
import com.projet.AppResidents.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambres")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

    // Créer une chambre
    @PostMapping
    public ResponseEntity<ChambreResponseDTO> createChambre(@RequestBody ChambreRequestDTO chambreRequestDTO) {
        ChambreResponseDTO responseDTO = chambreService.createChambre(chambreRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Récupérer une chambre par ID
    @GetMapping("/{id}")
    public ResponseEntity<ChambreResponseDTO> getChambreById(@PathVariable Long id) {
        ChambreResponseDTO responseDTO = chambreService.getChambreById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Récupérer toutes les chambres
    @GetMapping
    public ResponseEntity<List<ChambreResponseDTO>> getAllChambres() {
        List<ChambreResponseDTO> responseDTOs = chambreService.getAllChambres();
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    // Mettre à jour une chambre
    @PutMapping("/{id}")
    public ResponseEntity<ChambreResponseDTO> updateChambre(
            @PathVariable Long id, @RequestBody ChambreRequestDTO chambreRequestDTO) {
        ChambreResponseDTO responseDTO = chambreService.updateChambre(id, chambreRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Supprimer une chambre
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}