package com.projet.AppResidents.controller;


import com.projet.AppResidents.model.Technicien;
import com.projet.AppResidents.service.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/techniciens")
public class TechnicienController {
    @Autowired
    private TechnicienService technicienService;

    @GetMapping
    public List<Technicien> getAllTechniciens() {
        return technicienService.getAllTechniciens();
    }

    @GetMapping("/{id}")
    public Technicien getTechnicienById(@PathVariable Long id) {
        return technicienService.getTechnicienById(id);
    }

    @PostMapping
    public Technicien createTechnicien(@RequestBody Technicien technicien) {
        return technicienService.saveTechnicien(technicien);
    }

    @DeleteMapping("/{id}")
    public void deleteTechnicien(@PathVariable Long id) {
        technicienService.deleteTechnicien(id);
    }
}
