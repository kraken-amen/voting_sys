package com.projects.voting_system.services.Candidature;

import com.projects.voting_system.dto.CandidatureDTO;
import com.projects.voting_system.entities.Candidature;
import com.projects.voting_system.mapper.CandidatureMapper;
import com.projects.voting_system.repos.CandidatureRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidatureServiceImp implements CandidatureService{
    @Autowired
    CandidatureRepos candidatureRepos;
    @Override
    public Candidature saveCandidature(Candidature candidature) {
        return candidatureRepos.save(candidature);
    }

    @Override
    public Candidature getCandidatureById(Long cin) {
        return candidatureRepos.findById(cin).get();
    }

    @Override
    public CandidatureDTO updateCandidature(Long id, CandidatureDTO dto) {
        Candidature existingCandidature = candidatureRepos.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidature not found"));

        existingCandidature.setNom(dto.getNom());
        existingCandidature.setParti(dto.getParti());
        existingCandidature.setProgramme(dto.getProgramme());

        return CandidatureMapper.toDTO(candidatureRepos.save(existingCandidature));
    }

    @Override
    public void deleteCandidatureById(Long cin) {
        candidatureRepos.deleteById(cin);
    }

    @Override
    public List<Candidature> getAllCandidatures() {
        return candidatureRepos.findAll();
    }
}
