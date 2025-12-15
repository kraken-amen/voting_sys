package com.projects.voting_system.services.Vote;

import com.projects.voting_system.dto.VoteDTO;
import com.projects.voting_system.entities.Vote;

import java.util.List;

public interface VoteService {
    Vote saveVote(VoteDTO Vote);
    Vote getVoteById(Long id);
    VoteDTO updateVote(Long id,VoteDTO candidature);
    void deleteVoteById(Long id);
    List<Vote> getAllVotes();
}
