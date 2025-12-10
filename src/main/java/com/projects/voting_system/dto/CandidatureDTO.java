package com.projects.voting_system.dto;

import lombok.Data;

@Data
public class CandidatureDTO {
    private Long idCandidature;
    private String nom;
    private String parti;
    private String programme;
}
