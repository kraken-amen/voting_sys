package com.projects.voting_system.services.Selection;

import com.projects.voting_system.entities.Selection;
import com.projects.voting_system.repos.SelectionRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SelectionServiceImp implements SelectionService {
    @Autowired
    SelectionRepos selectionRepos;
    @Override
    public Selection saveSelection(Selection Selection) {
        return selectionRepos.save(Selection);
    }

    @Override
    public Selection getSelectionById(Long id) {
        return selectionRepos.findById(id).get();
    }

    @Override
    public void updateSelection(Long id, Selection selection) {
        selectionRepos.findById(id).ifPresent(selection1 -> {
            selection1.setDate(selection.getDate());
            selection1.setPostion(selection.getPostion());
            selectionRepos.save(selection1);
        });
    }

    @Override
    public void deleteSelectionById(Long id) {
        selectionRepos.deleteById(id);
    }

    @Override
    public List<Selection> getAllSelections() {
        return List.of();
    }
}
