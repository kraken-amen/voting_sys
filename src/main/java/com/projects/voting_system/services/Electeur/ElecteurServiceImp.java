package com.projects.voting_system.services.Electeur;

import com.projects.voting_system.entities.Electeur;
import com.projects.voting_system.repos.ElecteurRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ElecteurServiceImp implements ElecteurService {
    @Autowired
    ElecteurRepos electeurRepos;
    @Override
    public Electeur saveElecteur(Electeur electeur) {
        return electeurRepos.save(electeur);
    }

    @Override
    public Electeur getElecteurById(Long idElecteur) {
        return electeurRepos.findById(idElecteur).get();
    }

    @Override
    public void updateElecteur(Long id, Electeur elec) {
        electeurRepos.findById(id).ifPresent(electeur -> {
            electeur.setNomElecteur(elec.getNomElecteur());
            electeur.setPrenomElecteur(elec.getPrenomElecteur());
            electeur.setEmail(elec.getEmail());
            electeur.setPassword(elec.getPassword());
            electeurRepos.save(electeur);
        });

    }

    @Override
    public void deleteElecteurById(Long idElecteur) {
        electeurRepos.deleteById(idElecteur);
    }

    @Override
    public List<Electeur> getAllElecteurs() {
        return List.of();
    }
}
