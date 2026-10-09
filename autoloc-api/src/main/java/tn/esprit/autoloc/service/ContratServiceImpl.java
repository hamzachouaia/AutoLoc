package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.IContratRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final IContratRepository contratRepository;

    @Override
    public Contrat add(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> retrieveAll() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat retrieveById(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrat introuvable : " + id));
    }

    @Override
    @Transactional
    public Contrat update(Long id, Contrat contrat) {
        Contrat existing = retrieveById(id);
        existing.setDateSignature(contrat.getDateSignature());
        existing.setMontantTotal(contrat.getMontantTotal());
        existing.setValide(contrat.isValide());
        existing.setReservation(contrat.getReservation());
        return contratRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!contratRepository.existsById(id)) {
            throw new EntityNotFoundException("Contrat introuvable : " + id);
        }
        contratRepository.deleteById(id);
    }
}