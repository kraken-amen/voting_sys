package com.projects.voting_system.repos;

import com.projects.voting_system.entities.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepos extends JpaRepository<Candidature, Long> {
}
