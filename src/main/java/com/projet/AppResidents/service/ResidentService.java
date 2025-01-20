package com.projet.AppResidents.service;

import com.projet.AppResidents.dto.ResidentRequestDTO;
import com.projet.AppResidents.dto.ResidentResponseDTO;
import com.projet.AppResidents.model.Resident;
import com.projet.AppResidents.repository.ResidentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResidentService {

    @Autowired
    private ResidentRepository residentRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Créer un résident
    public ResidentResponseDTO createResident(ResidentRequestDTO residentRequestDTO) {
        Resident resident = modelMapper.map(residentRequestDTO, Resident.class);
        Resident savedResident = residentRepository.save(resident);
        return modelMapper.map(savedResident, ResidentResponseDTO.class);
    }

    // Récupérer un résident par ID
    public ResidentResponseDTO getResidentById(long id) {
        Resident resident = residentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resident not found"));
        return modelMapper.map(resident, ResidentResponseDTO.class);
    }

    // Récupérer tous les résidents
    public List<ResidentResponseDTO> getAllResidents() {
        List<Resident> residents = residentRepository.findAll();
        return residents.stream()
                .map(resident -> modelMapper.map(resident, ResidentResponseDTO.class))
                .collect(Collectors.toList());
    }

    // Mettre à jour un résident
    public ResidentResponseDTO updateResident(long id, ResidentRequestDTO residentRequestDTO) {
        Resident existingResident = residentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resident not found"));

        modelMapper.map(residentRequestDTO, existingResident); // Mise à jour des champs
        Resident updatedResident = residentRepository.save(existingResident);
        return modelMapper.map(updatedResident, ResidentResponseDTO.class);
    }

    // Supprimer un résident
    public void deleteResident(long id) {
        residentRepository.deleteById(id);
    }
}