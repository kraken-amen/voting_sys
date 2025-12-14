package com.projects.voting_system.services.Vote;

import com.projects.voting_system.entities.Vote;
import com.projects.voting_system.repos.VoteRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoteServiceImp implements VoteService {
    @Autowired
    VoteRepos voteRepos;
    @Override
    public Vote saveVote(Vote Vote) {
        return voteRepos.save(Vote);
    }
    @Override
    public Vote getVoteById(Long id) {
        return voteRepos.findById(id).get();
    }
    @Override
    public void updateVote(Long id, Vote vot) {
        voteRepos.findById(id).ifPresent(vote1 -> {
            vote1.setDateVote(vot.getDateVote());
        });
    voteRepos.save(vot);
    }
    @Override
    public void deleteVoteById(Long id) {
        voteRepos.deleteById(id);
    }
    @Override
    public List<Vote> getAllVotes() {
        return voteRepos.findAll();
    }
}
