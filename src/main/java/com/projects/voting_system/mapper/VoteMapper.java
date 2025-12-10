package com.projects.voting_system.mapper;

import com.projects.voting_system.dto.VoteDTO;
import com.projects.voting_system.entities.Vote;

public class VoteMapper {
    public static VoteDTO toDTO(Vote vote) {
        VoteDTO voteDTO = new VoteDTO();
        voteDTO.setIdVote(vote.getIdVote());
        voteDTO.setDateVote(vote.getDateVote());
        return voteDTO;
    }
    public static Vote toEntity(VoteDTO voteDTO) {
        Vote vote = new Vote();
        vote.setIdVote(voteDTO.getIdVote());
        vote.setDateVote(voteDTO.getDateVote());
        return vote;
    }
}
