package com.projet.AppResidents.service;
import com.projet.AppResidents.exception.ResourceNotFoundException;
import com.projet.AppResidents.model.Technicien;
import com.projet.AppResidents.repository.TechnicienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicienService {
    @Autowired
private TechnicienRepository technicienRepository;

public List<Technicien> getAllTechniciens() {
    return technicienRepository.findAll();
}

public Technicien getTechnicienById(Long id) {
    return technicienRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Technicien non trouvé"));
}

public Technicien saveTechnicien(Technicien technicien) {
    return technicienRepository.save(technicien);
}

public void deleteTechnicien(Long id) {
    technicienRepository.deleteById(id);
}
}
