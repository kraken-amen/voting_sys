package com.projects.voting_system.services.Selection;

import com.projects.voting_system.entities.Selection;

import java.util.List;

public interface SelectionService {
    Selection saveSelection(Selection Selection);
    Selection getSelectionById(Long id);
    void updateSelection(Long id,Selection candidature);
    void deleteSelectionById(Long id);
    List<Selection> getAllSelections();
}
