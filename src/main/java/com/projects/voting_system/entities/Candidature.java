package com.projects.voting_system.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    @OneToMany(mappedBy = "candidature",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vote> votes; // Une candidature reçoit plusieurs votes

    @OneToMany(mappedBy = "candidature",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Selection> selections;
}
