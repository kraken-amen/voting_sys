package com.projects.voting_system.controller;

import com.projects.voting_system.entities.Electeur;
import com.projects.voting_system.services.Electeur.ElecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/electeur")
public class ElecteurController {
    @Autowired
    ElecteurService ElecteurService;
    @GetMapping("/ele")
    public List<Electeur> getElecteurs() {
        return ElecteurService.getAllElecteurs();
    }
    @PostMapping("/ele")
    public void addElecteur(@RequestBody Electeur Electeur) {
        ElecteurService.saveElecteur(Electeur);
    }
    @PutMapping("/ele/{id}")
    public void updateElecteur(@RequestBody Electeur electeur, @PathVariable Long id) {
        electeur.setCin(id);
        ElecteurService.saveElecteur(electeur);
    }
    @DeleteMapping("/ele/{id}")
    public void deleteElecteur(@PathVariable Long id) {
        ElecteurService.deleteElecteurById(id);
    }
}
