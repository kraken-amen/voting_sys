package com.projects.voting_system.dto;

import lombok.Data;

import java.util.Date;
@Data
public class VoteDTO {
    private Long idVote;
    private Date dateVote;
}
