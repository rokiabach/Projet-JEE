package com.projet.AppResidents.controller;

import com.projet.AppResidents.dto.ResidentRequestDTO;
import com.projet.AppResidents.dto.ResidentResponseDTO;
import com.projet.AppResidents.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residents")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    // Créer un résident
    @PostMapping
    public ResponseEntity<ResidentResponseDTO> createResident(@RequestBody ResidentRequestDTO residentRequestDTO) {
        ResidentResponseDTO responseDTO = residentService.createResident(residentRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Récupérer un résident par ID
    @GetMapping("/{id}")
    public ResponseEntity<ResidentResponseDTO> getResidentById(@PathVariable long id) {
        ResidentResponseDTO responseDTO = residentService.getResidentById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Récupérer tous les résidents
    @GetMapping
    public ResponseEntity<List<ResidentResponseDTO>> getAllResidents() {
        List<ResidentResponseDTO> responseDTOs = residentService.getAllResidents();
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    // Mettre à jour un résident
    @PutMapping("/{id}")
    public ResponseEntity<ResidentResponseDTO> updateResident(
            @PathVariable long id, @RequestBody ResidentRequestDTO residentRequestDTO) {
        ResidentResponseDTO responseDTO = residentService.updateResident(id, residentRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Supprimer un résident
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResident(@PathVariable long id) {
        residentService.deleteResident(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}