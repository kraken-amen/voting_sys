package com.projects.voting_system.mapper;

import com.projects.voting_system.dto.ElecteurDTO;
import com.projects.voting_system.entities.Electeur;

public class ElecteurMapper {
    public static ElecteurDTO toDTO(Electeur electeur) {
        ElecteurDTO electeurDTO = new ElecteurDTO();
        electeurDTO.setCin(electeur.getCin());
        electeurDTO.setNomElecteur(electeur.getNomElecteur());
        electeurDTO.setPrenomElecteur(electeur.getPrenomElecteur());
        electeurDTO.setEmail(electeur.getEmail());
        electeurDTO.setPassword(electeur.getPassword());
        return electeurDTO;
    }
    public static Electeur toEntity(ElecteurDTO electeurDTO) {
        Electeur electeur = new Electeur();
        electeur.setCin(electeurDTO.getCin());
        electeur.setNomElecteur(electeurDTO.getNomElecteur());
        electeur.setPrenomElecteur(electeurDTO.getPrenomElecteur());
        electeur.setEmail(electeurDTO.getEmail());
        electeur.setPassword(electeurDTO.getPassword());
        return electeur;
    }
}
