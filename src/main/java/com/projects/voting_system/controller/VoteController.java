package com.projects.voting_system.controller;

import com.projects.voting_system.dto.VoteDTO;
import com.projects.voting_system.entities.Vote;
import com.projects.voting_system.mapper.VoteMapper;
import com.projects.voting_system.services.Vote.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Vote")
public class VoteController {
    @Autowired
    VoteService voteService;
    @GetMapping("/vo")
    public List<VoteDTO> getVotes() {
        return voteService.getAllVotes().stream().map(VoteMapper::toDTO).collect(Collectors.toList());
    }
    @PostMapping("/vo")
    public Vote addVote(@RequestBody VoteDTO vote) {
        return voteService.saveVote(vote);
    }
    @PutMapping(value = "/vo/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VoteDTO> updateVote(
            @PathVariable Long id,
            @RequestBody VoteDTO voteDTO) {
        VoteDTO updatedVote = voteService.updateVote(id, voteDTO);
        return ResponseEntity.ok(updatedVote);
    }

    @DeleteMapping("/vo/{id}")
    public void deleteVote(@PathVariable Long id) {
        voteService.deleteVoteById(id);
    }
}
