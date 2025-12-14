package com.projects.voting_system.controller;

import com.projects.voting_system.dto.CandidatureDTO;
import com.projects.voting_system.dto.ElecteurDTO;
import com.projects.voting_system.entities.Electeur;
import com.projects.voting_system.mapper.ElecteurMapper;
import com.projects.voting_system.services.Electeur.ElecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/electeur")
public class ElecteurController {
    @Autowired
    ElecteurService ElecteurService;
    @GetMapping("/ele")
    public List<ElecteurDTO> getElecteurs() {
        return ElecteurService.getAllElecteurs().stream().map(ElecteurMapper::toDTO).collect(Collectors.toList());
    }
    @PostMapping("/ele")
    public ElecteurDTO addElecteur(@RequestBody ElecteurDTO electeur) {
        Electeur entity = ElecteurMapper.toEntity(electeur);
        Electeur e=ElecteurService.saveElecteur(entity);
        ResponseEntity.ok("electeur ajouté avec succès !");
        return ElecteurMapper.toDTO(e);
    }
    @PutMapping("/ele/{id}")
    public void updateElecteur(@RequestBody Electeur electeur, @PathVariable Long id) {
        ResponseEntity.ok("electeur modifier avec succès !");
        ElecteurService.updateElecteur(id,electeur);
    }
    @DeleteMapping("/ele/{id}")
    public void deleteElecteur(@PathVariable Long id) {
        ResponseEntity.ok("electeur supprimer avec succès !");
        ElecteurService.deleteElecteurById(id);
    }
}
