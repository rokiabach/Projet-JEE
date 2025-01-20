package com.projet.AppResidents.controller;


import com.projet.AppResidents.model.Administrateur;
import com.projet.AppResidents.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdministrateurController {

    @Autowired
    private AdministrateurService administrateurService;

   /* @GetMapping
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurService.getAllAdministrateurs();
    }*/

    @GetMapping("/{id}")
    public Administrateur getAdministrateurById(@PathVariable Long id) {
        return administrateurService.getAdministrateurById(id);
    }

    @PostMapping
    public Administrateur createAdministrateur(@RequestBody Administrateur administrateur) {
        return administrateurService.saveAdministrateur(administrateur);
    }

    /*@DeleteMapping("/{id}")
    public void deleteAdministrateur(@PathVariable Long id) {
        administrateurService.deleteAdministrateur(id);
    }*/
}
