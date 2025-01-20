package com.projet.AppResidents.service;

import com.projet.AppResidents.dto.ChambreRequestDTO;
import com.projet.AppResidents.dto.ChambreResponseDTO;
import com.projet.AppResidents.model.Chambre;
import com.projet.AppResidents.repository.AdministrateurRepository;
import com.projet.AppResidents.repository.ChambreRepository;
import com.projet.AppResidents.repository.ResidentRepository;
import com.projet.AppResidents.repository.RequeteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private ResidentRepository residentRepository;

    @Autowired
    private AdministrateurRepository administrateurRepository;

    @Autowired
    private RequeteRepository requeteRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Créer une chambre
    public ChambreResponseDTO createChambre(ChambreRequestDTO chambreRequestDTO) {
        Chambre chambre = modelMapper.map(chambreRequestDTO, Chambre.class);

        // Gérer les relations manuellement
        /*if (chambreRequestDTO.getResidentId() != null) {
            chambre.setResident(residentRepository.findById(chambreRequestDTO.getResidentId())
                    .orElseThrow(() -> new RuntimeException("Résident non trouvé")));
        }*/

        /*if (chambreRequestDTO.getAdministrateurId() != null) {
            chambre.setAdministrateur(administrateurRepository.findById(chambreRequestDTO.getAdministrateurId())
                    .orElseThrow(() -> new RuntimeException("Administrateur non trouvé")));
        }*/

        Chambre savedChambre = chambreRepository.save(chambre);
        return modelMapper.map(savedChambre, ChambreResponseDTO.class);
    }

    // Récupérer une chambre par ID
    public ChambreResponseDTO getChambreById(Long id) {
        Chambre chambre = chambreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chambre non trouvée"));
        return modelMapper.map(chambre, ChambreResponseDTO.class);
    }

    // Récupérer toutes les chambres
    public List<ChambreResponseDTO> getAllChambres() {
        List<Chambre> chambres = chambreRepository.findAll();
        return chambres.stream()
                .map(chambre -> modelMapper.map(chambre, ChambreResponseDTO.class))
                .collect(Collectors.toList());
    }

    // Mettre à jour une chambre
    public ChambreResponseDTO updateChambre(Long id, ChambreRequestDTO chambreRequestDTO) {
        Chambre existingChambre = chambreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chambre non trouvée"));

        // Mapper les propriétés de base
        modelMapper.map(chambreRequestDTO, existingChambre);

        // Gérer les relations manuellement
        /*if (chambreRequestDTO.getResidentId() != null) {
            existingChambre.setResident(residentRepository.findById(chambreRequestDTO.getResidentId())
                    .orElseThrow(() -> new RuntimeException("Résident non trouvé")));
        }*/

        /*if (chambreRequestDTO.getAdministrateurId() != null) {
            existingChambre.setAdministrateur(administrateurRepository.findById(chambreRequestDTO.getAdministrateurId())
                    .orElseThrow(() -> new RuntimeException("Administrateur non trouvé")));
        }*/

        Chambre updatedChambre = chambreRepository.save(existingChambre);
        return modelMapper.map(updatedChambre, ChambreResponseDTO.class);
    }

    // Supprimer une chambre
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }
}