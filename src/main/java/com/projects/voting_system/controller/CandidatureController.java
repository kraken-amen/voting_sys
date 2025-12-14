package com.projects.voting_system.controller;

import com.projects.voting_system.dto.CandidatureDTO;
import com.projects.voting_system.entities.Candidature;
import com.projects.voting_system.mapper.CandidatureMapper;
import com.projects.voting_system.services.Candidature.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/candidature")
public class CandidatureController {
    @Autowired
    CandidatureService candidatureService;
    @GetMapping("/can")
    public List<CandidatureDTO> getCandidatures() {
        return candidatureService.getAllCandidatures().stream().map(CandidatureMapper::toDTO).collect(Collectors.toList());
    }
    @PostMapping("/can")
    public CandidatureDTO addCandidature(@RequestBody CandidatureDTO candidature) {
        Candidature entity = CandidatureMapper.toEntity(candidature);
        Candidature c=candidatureService.saveCandidature(entity);
        ResponseEntity.ok("candidature ajouté avec succès !");
        return CandidatureMapper.toDTO(c);
    }
    @PutMapping("/can/{id}")
    public void updateCandidature(@RequestBody Candidature candidature, @PathVariable Long id) {
        ResponseEntity.ok("candidature modifier avec succès !");
        candidatureService.updateCandidature(id, candidature);
    }
    @DeleteMapping("/can/{id}")
    public void deleteCandidature(@PathVariable Long id) {
        ResponseEntity.ok("candidature supprimer avec succès !");
        candidatureService.deleteCandidatureById(id);
    }

}
