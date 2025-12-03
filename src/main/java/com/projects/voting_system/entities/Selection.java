package com.projects.voting_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity

public class Selection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSelection;
    private String postion;
    private Date date;

    public Selection(String postion, Date date) {
        this.postion = postion;
        this.date = date;
    }
    public Selection() {}
}
