package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.IVehiculeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;

    @Override
    public Vehicule add(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> retrieveAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule retrieveById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable : " + id));
    }

    @Override
    @Transactional
    public Vehicule update(Long id, Vehicule vehicule) {
        Vehicule existing = retrieveById(id);
        existing.setImmatriculation(vehicule.getImmatriculation());
        existing.setMarque(vehicule.getMarque());
        existing.setModele(vehicule.getModele());
        existing.setCategorie(vehicule.getCategorie());
        existing.setTarifJournalier(vehicule.getTarifJournalier());
        existing.setStatut(vehicule.getStatut());
        existing.setAgence(vehicule.getAgence());
        return vehiculeRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new EntityNotFoundException("Vehicule introuvable : " + id);
        }
        vehiculeRepository.deleteById(id);
    }
}