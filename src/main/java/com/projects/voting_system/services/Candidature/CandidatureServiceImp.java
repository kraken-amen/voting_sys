package com.projects.voting_system.services.Candidature;

import com.projects.voting_system.entities.Candidature;
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
    public Candidature getCandidatureById(Long idCandidature) {
        return candidatureRepos.findById(Math.toIntExact(idCandidature)).get();
    }

    @Override
    public void updateCandidature(Long idCandidature, Candidature candidature) {
        candidatureRepos.findById(Math.toIntExact(idCandidature)).ifPresent(Candidature -> {
            Candidature.setNom(candidature.getNom());
            Candidature.setParti(candidature.getParti());
            Candidature.setProgramme(candidature.getProgramme());
            candidatureRepos.save(Candidature);
        });}

    @Override
    public void deleteCandidatureById(Long idCandidature) {
        candidatureRepos.deleteById(Math.toIntExact(idCandidature));
    }

    @Override
    public List<Candidature> getAllCandidatures() {
        return List.of();
    }
}
