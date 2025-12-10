package com.projects.voting_system.mapper;

import com.projects.voting_system.dto.SelectionDTO;
import com.projects.voting_system.entities.Selection;

public class SelectionMapper {
    public static SelectionDTO toDTO(Selection selection) {
        SelectionDTO selectionDTO = new SelectionDTO();
        selectionDTO.setIdSelection(selection.getIdSelection());
        selectionDTO.setPostion(selection.getPostion());
        selectionDTO.setDate(selection.getDate());
        return selectionDTO;
    }
    public static Selection toEntity(SelectionDTO selectionDTO) {
        Selection selection = new Selection();
        selection.setIdSelection(selectionDTO.getIdSelection());
        selection.setPostion(selectionDTO.getPostion());
        selection.setDate(selectionDTO.getDate());
        return selection;
    }
}
