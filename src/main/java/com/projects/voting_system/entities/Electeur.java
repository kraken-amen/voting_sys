package com.projects.voting_system.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Electeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cin;
    private String nomElecteur;
    private String prenomElecteur;
    private String email;
    private String password;

    public Electeur() {
    }

    public Electeur(String nomElecteur, String prenomElecteur, String email, String password) {
        this.nomElecteur = nomElecteur;
        this.prenomElecteur = prenomElecteur;
        this.email = email;
        this.password = password;
    }
//    @OneToOne(mappedBy = "Electeur")
//    private Vote vote;

}
