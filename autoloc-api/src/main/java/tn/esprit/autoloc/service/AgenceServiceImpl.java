package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final IAgenceRepository agenceRepository;

    @Override
    public Agence add(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> retrieveAll() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence retrieveById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + id));
    }

    @Override
    @Transactional
    public Agence update(Long id, Agence agence) {
        Agence existing = retrieveById(id);
        existing.setNom(agence.getNom());
        existing.setVille(agence.getVille());
        existing.setAdresse(agence.getAdresse());
        existing.setTelephone(agence.getTelephone());
        return agenceRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!agenceRepository.existsById(id)) {
            throw new EntityNotFoundException("Agence introuvable : " + id);
        }
        agenceRepository.deleteById(id);
    }
}