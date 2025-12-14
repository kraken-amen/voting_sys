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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CIN_elec",referencedColumnName = "cin", nullable = false)
    private Electeur electeur; // Un vote est fait par un électeur

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidature_id",nullable = false)
    private Candidature candidature;
}
