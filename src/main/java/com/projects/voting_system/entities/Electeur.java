package com.projects.voting_system.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Electeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElecteur;
    private String nomElecteur;
    private String prenomElecteur;
    private String cin;
    private String email;
    private String password;

    public Electeur() {
    }

    public Electeur(String nomElecteur, String prenomElecteur, String cin, String email, String password) {
        this.nomElecteur = nomElecteur;
        this.prenomElecteur = prenomElecteur;
        this.cin = cin;
        this.email = email;
        this.password = password;
    }
//    @OneToOne(mappedBy = "Electeur")
//    private Vote vote;

}
