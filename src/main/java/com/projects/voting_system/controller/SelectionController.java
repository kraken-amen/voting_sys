package com.projects.voting_system.controller;

import com.projects.voting_system.entities.Selection;
import com.projects.voting_system.services.Selection.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/selection")
public class SelectionController {
    @Autowired
    SelectionService SelectionService;
    @GetMapping("/sel")
    public List<Selection> getSelections() {
        return SelectionService.getAllSelections();
    }
    @PostMapping("/sel")
    public void addSelection(@RequestBody Selection selection) {
        SelectionService.saveSelection(selection);
    }
    @PutMapping("/sel/{id}")
    public void updateSelection(@RequestBody Selection selection, @PathVariable Long id) {
        selection.setIdSelection(id);
        SelectionService.saveSelection(selection);
    }
    @DeleteMapping("/sel/{id}")
    public void deleteSelection(@PathVariable Long id) {
        SelectionService.deleteSelectionById(id);
    }
    
}
