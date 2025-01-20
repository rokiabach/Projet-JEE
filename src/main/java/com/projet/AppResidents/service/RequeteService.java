package com.projet.AppResidents.service;

import com.projet.AppResidents.dto.RequeteRequestDTO;
import com.projet.AppResidents.dto.RequeteResponseDTO;
import com.projet.AppResidents.model.Requete;
import com.projet.AppResidents.repository.RequeteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequeteService {

    @Autowired
    private RequeteRepository requeteRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Créer une requête
    public RequeteResponseDTO createRequete(RequeteRequestDTO requeteRequestDTO) {
        Requete requete = modelMapper.map(requeteRequestDTO, Requete.class);
        Requete savedRequete = requeteRepository.save(requete);
        return modelMapper.map(savedRequete, RequeteResponseDTO.class);
    }

    // Récupérer une requête par ID
    public RequeteResponseDTO getRequeteById(Long id) {
        Requete requete = requeteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Requête non trouvée"));
        return modelMapper.map(requete, RequeteResponseDTO.class);
    }

    // Récupérer toutes les requêtes
    public List<RequeteResponseDTO> getAllRequetes() {
        List<Requete> requetes = requeteRepository.findAll();
        return requetes.stream()
                .map(requete -> modelMapper.map(requete, RequeteResponseDTO.class))
                .collect(Collectors.toList());
    }

    // Mettre à jour une requête
    public RequeteResponseDTO updateRequete(Long id, RequeteRequestDTO requeteRequestDTO) {
        Requete existingRequete = requeteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Requête non trouvée"));

        modelMapper.map(requeteRequestDTO, existingRequete); // Mise à jour des champs
        Requete updatedRequete = requeteRepository.save(existingRequete);
        return modelMapper.map(updatedRequete, RequeteResponseDTO.class);
    }

    // Supprimer une requête
    public void deleteRequete(Long id) {
        requeteRepository.deleteById(id);
    }
}