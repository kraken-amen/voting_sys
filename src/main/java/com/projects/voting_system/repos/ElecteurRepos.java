package com.projects.voting_system.repos;

import com.projects.voting_system.entities.Electeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElecteurRepos extends JpaRepository<Electeur, Integer> {
}
