package com.projects.voting_system.repos;

import com.projects.voting_system.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepos extends JpaRepository<Vote, Integer> {
}
