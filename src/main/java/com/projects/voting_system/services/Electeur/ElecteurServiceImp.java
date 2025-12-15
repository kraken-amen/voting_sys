package com.projects.voting_system.services.Electeur;

import com.projects.voting_system.dto.ElecteurDTO;
import com.projects.voting_system.entities.Electeur;
import com.projects.voting_system.mapper.ElecteurMapper;
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
    public ElecteurDTO updateElecteur(Long cin, ElecteurDTO dto) {
        Electeur existingElecteur = electeurRepos.findById(cin)
                .orElseThrow(() -> new RuntimeException("Electeur not found"));

        existingElecteur.setNomElecteur(dto.getNomElecteur());
        existingElecteur.setPrenomElecteur(dto.getPrenomElecteur());
        existingElecteur.setEmail(dto.getEmail());
        existingElecteur.setPassword(dto.getPassword());

        return ElecteurMapper.toDTO(electeurRepos.save(existingElecteur));
    }


    @Override
    public void deleteElecteurById(Long idElecteur) {
        electeurRepos.deleteById(idElecteur);
    }

    @Override
    public List<Electeur> getAllElecteurs() {
        return electeurRepos.findAll();
    }
}
