package com.projects.voting_system.services.Vote;

import com.projects.voting_system.entities.Vote;

import java.util.List;

public interface VoteService {
    Vote saveVote(Vote Vote);
    Vote getVoteById(Long id);
    void updateVote(Long id,Vote candidature);
    void deleteVoteById(Long id);
    List<Vote> getAllVotes();
}
