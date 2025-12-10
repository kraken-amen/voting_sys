package com.projects.voting_system.dto;

import lombok.Data;

@Data
public class ElecteurDTO {
    private Long cin;
    private String nomElecteur;
    private String prenomElecteur;
    private String email;
    private String password;
}
