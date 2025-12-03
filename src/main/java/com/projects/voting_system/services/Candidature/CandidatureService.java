package com.projects.voting_system.services.Candidature;

import com.projects.voting_system.entities.Candidature;

import java.util.List;

public interface CandidatureService {
    Candidature saveCandidature(Candidature candidature);
    Candidature getCandidatureById(Long id);
    void updateCandidature(Long id,Candidature candidature);
    void deleteCandidatureById(Long id);

    List<Candidature> getAllCandidatures();
}
