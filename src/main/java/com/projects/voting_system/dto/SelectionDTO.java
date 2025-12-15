package com.projects.voting_system.dto;

import com.projects.voting_system.entities.posType;
import lombok.Data;

import java.util.Date;
@Data
public class SelectionDTO {
    private Long idSelection;
    private posType postion;
    private Date date;
    private Long CIN_elec;
    private Long candidature_id;
}
