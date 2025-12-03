package com.projects.voting_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidature;
    private String nom;
    private String parti;
    private String programme;

    public Candidature(String nom, String parti, String programme) {
        this.nom = nom;
        this.parti = parti;
        this.programme = programme;
    }

    public Candidature() {

    }
}
