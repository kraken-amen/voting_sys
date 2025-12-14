package com.projects.voting_system.controller;

import com.projects.voting_system.dto.SelectionDTO;
import com.projects.voting_system.entities.Selection;
import com.projects.voting_system.mapper.SelectionMapper;
import com.projects.voting_system.services.Selection.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/selection")
public class SelectionController {
    @Autowired
    SelectionService SelectionService;
    @GetMapping("/sel")
    public List<SelectionDTO> getSelections() {
        return SelectionService.getAllSelections().stream().map(SelectionMapper::toDTO).collect(Collectors.toList());
    }
    @PostMapping("/sel")
    public void addSelection(@RequestBody SelectionDTO selection) {
        Selection selectionEntity = SelectionMapper.toEntity(selection);
        Selection s=SelectionService.saveSelection(selectionEntity);
        SelectionService.saveSelection(s);
    }
    @PutMapping("/sel/{id}")
    public void updateSelection(@RequestBody Selection selection, @PathVariable Long id) {
        SelectionService.updateSelection(id,selection);
    }
    @DeleteMapping("/sel/{id}")
    public void deleteSelection(@PathVariable Long id) {
        SelectionService.deleteSelectionById(id);
    }
    
}
