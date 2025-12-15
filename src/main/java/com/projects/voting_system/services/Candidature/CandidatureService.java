package com.projects.voting_system.services.Candidature;

import com.projects.voting_system.dto.CandidatureDTO;
import com.projects.voting_system.entities.Candidature;

import java.util.List;

public interface CandidatureService {
    Candidature saveCandidature(Candidature candidature);
    Candidature getCandidatureById(Long id);
    CandidatureDTO updateCandidature(Long id, CandidatureDTO candidature);
    void deleteCandidatureById(Long id);

    List<Candidature> getAllCandidatures();
}
