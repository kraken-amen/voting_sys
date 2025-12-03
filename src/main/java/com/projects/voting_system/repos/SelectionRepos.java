package com.projects.voting_system.repos;

import com.projects.voting_system.entities.Selection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectionRepos extends JpaRepository<Selection, Long> {

}
