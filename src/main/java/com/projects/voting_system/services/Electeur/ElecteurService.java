package com.projects.voting_system.services.Electeur;

import com.projects.voting_system.dto.ElecteurDTO;
import com.projects.voting_system.entities.Candidature;
import com.projects.voting_system.entities.Electeur;

import java.util.List;

public interface ElecteurService {
    Electeur saveElecteur(Electeur electeur);
    Electeur getElecteurById(Long id);
    ElecteurDTO updateElecteur(Long id, ElecteurDTO candidature);
    void deleteElecteurById(Long id);
    List<Electeur> getAllElecteurs();
}
