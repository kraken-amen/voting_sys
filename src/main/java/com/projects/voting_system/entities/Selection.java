package com.projects.voting_system.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity

public class Selection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSelection;
    private posType postion;
    private Date date;

    public Selection(posType postion, Date date) {
        this.postion = postion;
        this.date = date;
    }
    public Selection() {}
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CIN_elec",referencedColumnName = "cin", nullable = false)
    private Electeur electeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidature_id",nullable = false)
    private Candidature candidature;
}
