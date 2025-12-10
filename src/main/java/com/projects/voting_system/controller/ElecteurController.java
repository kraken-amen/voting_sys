package com.projects.voting_system.controller;

import com.projects.voting_system.dto.ElecteurDTO;
import com.projects.voting_system.entities.Electeur;
import com.projects.voting_system.mapper.ElecteurMapper;
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
    public ElecteurDTO addElecteur(@RequestBody ElecteurDTO electeur) {
        Electeur entity = ElecteurMapper.toEntity(electeur);
        Electeur e=ElecteurService.saveElecteur(entity);
        return ElecteurMapper.toDTO(e);
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
