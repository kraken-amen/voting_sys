package com.projects.voting_system.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.DateTimeException;
import java.util.Date;
@Data
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVote;
    private Date dateVote;

    public Vote(Date dateVote) {
        this.dateVote = dateVote;
    }

    public Vote() {

    }
    @ManyToOne
    @JoinColumn(name = "CIN_elec")
    private Electeur electeur; // Un vote est fait par un électeur

    @ManyToOne
    @JoinColumn(name = "candidature_id")
    private Candidature candidature;
}
