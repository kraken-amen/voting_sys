package com.projects.voting_system.services.Vote;

import com.projects.voting_system.dto.SelectionDTO;
import com.projects.voting_system.dto.VoteDTO;
import com.projects.voting_system.entities.Candidature;
import com.projects.voting_system.entities.Electeur;
import com.projects.voting_system.entities.Selection;
import com.projects.voting_system.entities.Vote;
import com.projects.voting_system.mapper.VoteMapper;
import com.projects.voting_system.repos.CandidatureRepos;
import com.projects.voting_system.repos.ElecteurRepos;
import com.projects.voting_system.repos.VoteRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoteServiceImp implements VoteService {
    @Autowired
    VoteRepos voteRepos;
    @Autowired
    ElecteurRepos electeurRepos;
    @Autowired
    CandidatureRepos candidatureRepos;
    @Override
    public Vote saveVote(VoteDTO dto) {

        // candidature
        Candidature c = candidatureRepos.findById(dto.getCandidature_id())
                .orElseThrow(() -> new RuntimeException("Candidature not found"));

        // electeur
        Electeur e = electeurRepos.findById(dto.getCIN_elec())
                .orElseThrow(() -> new RuntimeException("Electeur not found"));

        Vote s = new Vote();
        s.setDateVote(dto.getDateVote());
        s.setCandidature(c);
        s.setElecteur(e);

        return voteRepos.save(s);
    }
    @Override
    public Vote getVoteById(Long id) {
        return voteRepos.findById(id).get();
    }
    @Override
    public VoteDTO updateVote(Long id, VoteDTO dto) {
        Vote s = voteRepos.findById(id)
                .orElseThrow(() -> new RuntimeException("Vote not found"));

        Candidature c = candidatureRepos.findById(dto.getCandidature_id())
                .orElseThrow(() -> new RuntimeException("Candidature not found"));

        Electeur e = electeurRepos.findById(dto.getCIN_elec())
                .orElseThrow(() -> new RuntimeException("Electeur not found"));

        // تحديث الحقول فقط
        s.setDateVote(dto.getDateVote());
        s.setCandidature(c);
        s.setElecteur(e);

        // حفظ الـ vote المحدث
        return VoteMapper.toDTO(voteRepos.save(s));
    }

    @Override
    public void deleteVoteById(Long id) {
        voteRepos.deleteById(id);
    }
    @Override
    public List<Vote> getAllVotes() {
        return voteRepos.findAll();
    }
}
