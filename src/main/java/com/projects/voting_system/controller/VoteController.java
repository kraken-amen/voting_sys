package com.projects.voting_system.controller;

import com.projects.voting_system.entities.Vote;
import com.projects.voting_system.services.Vote.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Vote")
public class VoteController {
    @Autowired
    VoteService voteService;
    @GetMapping("/can")
    public List<Vote> getVotes() {
        return voteService.getAllVotes();
    }
    @PostMapping("/can")
    public void addVote(@RequestBody Vote vote) {
        voteService.saveVote(vote);
    }
    @PutMapping("/can/{id}")
    public void updateVote(@RequestBody Vote vote, @PathVariable Long id) {
        vote.setIdVote(id);
        voteService.saveVote(vote);
    }
    @DeleteMapping("/can/{id}")
    public void deleteVote(@PathVariable Long id) {
        voteService.deleteVoteById(id);
    }
}
