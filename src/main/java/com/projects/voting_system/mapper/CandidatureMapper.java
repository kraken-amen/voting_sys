package com.projects.voting_system.mapper;

import com.projects.voting_system.dto.CandidatureDTO;
import com.projects.voting_system.entities.Candidature;

public class CandidatureMapper {
    public static CandidatureDTO toDTO(Candidature candidature)
    {
        CandidatureDTO candidatureDTO = new CandidatureDTO();
        candidatureDTO.setIdCandidature(candidature.getIdCandidature());
        candidatureDTO.setNom(candidature.getNom());
        candidatureDTO.setParti(candidature.getParti());
        candidatureDTO.setProgramme(candidature.getProgramme());
        return candidatureDTO;
    }
    public static Candidature toEntity(CandidatureDTO candidatureDTO)
    {
        Candidature candidature = new Candidature();
        candidature.setIdCandidature(candidatureDTO.getIdCandidature());
        candidature.setNom(candidatureDTO.getNom());
        candidature.setParti(candidatureDTO.getParti());
        candidature.setProgramme(candidatureDTO.getProgramme());
        return candidature;
    }
}
