package com.projects.voting_system.services.Selection;

import com.projects.voting_system.dto.SelectionDTO;
import com.projects.voting_system.entities.Selection;

import java.util.List;

public interface SelectionService {
    Selection saveSelection(SelectionDTO Selection);
    Selection getSelectionById(Long id);
    SelectionDTO updateSelection(Long id,SelectionDTO candidature);
    void deleteSelectionById(Long id);
    List<Selection> getAllSelections();
}
