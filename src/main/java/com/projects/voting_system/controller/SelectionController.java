package com.projects.voting_system.controller;

import com.projects.voting_system.dto.SelectionDTO;
import com.projects.voting_system.entities.Selection;
import com.projects.voting_system.mapper.SelectionMapper;
import com.projects.voting_system.services.Selection.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public Selection addSelection(@RequestBody SelectionDTO dto) {
        return SelectionService.saveSelection(dto);
    }
    @PutMapping(value = "/sel/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SelectionDTO> updateSelection(
            @PathVariable Long id,
            @RequestBody SelectionDTO selectionDTO) {
        SelectionDTO updatedSelection = SelectionService.updateSelection(id, selectionDTO);
        return ResponseEntity.ok(updatedSelection);
    }

    @DeleteMapping("/sel/{id}")
    public void deleteSelection(@PathVariable Long id) {
        SelectionService.deleteSelectionById(id);
    }
    
}
