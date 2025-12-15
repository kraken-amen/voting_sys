package com.projects.voting_system.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Electeur {
    @Id
    private Long cin;
    private String nomElecteur;
    private String prenomElecteur;
    private String email;
    private String password;
    public Electeur() {
    }

    public Electeur(Long cin,String nomElecteur, String prenomElecteur, String email, String password) {
        this.cin=cin;
        this.nomElecteur = nomElecteur;
        this.prenomElecteur = prenomElecteur;
        this.email = email;
        this.password = password;
    }
    @OneToMany(mappedBy = "electeur",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Vote> votes; // Un électeur peut faire plusieurs votes

    @OneToMany(mappedBy = "electeur",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Selection> selections; // Un électeur peut avoir plusieurs sélections
}
