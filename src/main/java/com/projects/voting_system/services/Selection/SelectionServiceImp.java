package com.projects.voting_system.services.Selection;

import com.projects.voting_system.dto.SelectionDTO;
import com.projects.voting_system.entities.Candidature;
import com.projects.voting_system.entities.Electeur;
import com.projects.voting_system.entities.Selection;
import com.projects.voting_system.mapper.SelectionMapper;
import com.projects.voting_system.repos.CandidatureRepos;
import com.projects.voting_system.repos.ElecteurRepos;
import com.projects.voting_system.repos.SelectionRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SelectionServiceImp implements SelectionService {
    @Autowired
    SelectionRepos selectionRepos;
    @Autowired
    CandidatureRepos candidatureRepos;
    @Autowired
    ElecteurRepos electeurRepos;
    @Override
    public Selection saveSelection(SelectionDTO dto) {

        // candidature
        Candidature c = candidatureRepos.findById(dto.getCandidature_id())
                .orElseThrow(() -> new RuntimeException("Candidature not found"));

        // electeur
        Electeur e = electeurRepos.findById(dto.getCIN_elec())
                .orElseThrow(() -> new RuntimeException("Electeur not found"));

        Selection s = new Selection();
        s.setPostion(dto.getPostion());
        s.setDate(dto.getDate());
        s.setCandidature(c);
        s.setElecteur(e);

        return selectionRepos.save(s);
    }
    @Override
    public Selection getSelectionById(Long id) {
        return selectionRepos.findById(id).get();
    }
    @Override
    public SelectionDTO updateSelection(Long id, SelectionDTO dto) {
        Selection s = selectionRepos.findById(id)
                .orElseThrow(() -> new RuntimeException("Selection not found"));

        Candidature c = candidatureRepos.findById(dto.getCandidature_id())
                .orElseThrow(() -> new RuntimeException("Candidature not found"));

        Electeur e = electeurRepos.findById(dto.getCIN_elec())
                .orElseThrow(() -> new RuntimeException("Electeur not found"));

        s.setPostion(dto.getPostion());
        s.setDate(dto.getDate());
        s.setCandidature(c);
        s.setElecteur(e);

        return SelectionMapper.toDTO(selectionRepos.save(s));
    }


    @Override
    public void deleteSelectionById(Long id) {
        selectionRepos.deleteById(id);
    }

    @Override
    public List<Selection> getAllSelections() {
        return selectionRepos.findAll();
    }
}
