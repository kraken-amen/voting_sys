package com.projects.voting_system.controller;

import com.projects.voting_system.entities.Candidature;
import com.projects.voting_system.services.Candidature.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidature")
public class CandidatureController {
    @Autowired
    CandidatureService candidatureService;
    @GetMapping("/can")
    public List<Candidature> getCandidatures() {
        return candidatureService.getAllCandidatures();
    }
    @PostMapping("/can")
    public void addCandidature(@RequestBody Candidature candidature) {
        candidatureService.saveCandidature(candidature);
    }
    @PutMapping("/can/{id}")
    public void updateCandidature(@RequestBody Candidature candidature, @PathVariable Long id) {
        candidature.setIdCandidature(id);
        candidatureService.saveCandidature(candidature);
    }
    @DeleteMapping("/can/{id}")
    public void deleteCandidature(@PathVariable Long id) {
        candidatureService.deleteCandidatureById(id);
    }

}
