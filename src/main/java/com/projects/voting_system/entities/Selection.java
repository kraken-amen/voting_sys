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
    private posType postion;
    private Date date;

    public Selection(posType postion, Date date) {
        this.postion = postion;
        this.date = date;
    }
    public Selection() {}
}
