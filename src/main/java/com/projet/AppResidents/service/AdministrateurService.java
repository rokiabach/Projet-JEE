package com.projet.AppResidents.service;
import com.projet.AppResidents.exception.ResourceNotFoundException;
import com.projet.AppResidents.model.Administrateur;
import com.projet.AppResidents.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService {

    @Autowired
    private AdministrateurRepository administrateurRepository;

    public Administrateur getAdministrateurById(Long id) {
        return administrateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Administrateur non trouvé"));
    }

    /*public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }*/

    public Administrateur saveAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    /*public void deleteAdministrateur(Long id) {
        administrateurRepository.deleteById(id);
    }*/
}
