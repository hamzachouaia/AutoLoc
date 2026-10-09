package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.IPaiementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiementRepository paiementRepository;

    @Override
    public Paiement add(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public List<Paiement> retrieveAll() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement retrieveById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable : " + id));
    }

    @Override
    @Transactional
    public Paiement update(Long id, Paiement paiement) {
        Paiement existing = retrieveById(id);
        existing.setMontant(paiement.getMontant());
        existing.setDatePaiement(paiement.getDatePaiement());
        existing.setModePaiement(paiement.getModePaiement());
        existing.setContrat(paiement.getContrat());
        return paiementRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!paiementRepository.existsById(id)) {
            throw new EntityNotFoundException("Paiement introuvable : " + id);
        }
        paiementRepository.deleteById(id);
    }
}