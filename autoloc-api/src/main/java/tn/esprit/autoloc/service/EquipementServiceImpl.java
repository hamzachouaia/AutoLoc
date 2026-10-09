package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.IEquipementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private final IEquipementRepository equipementRepository;

    @Override
    public Equipement add(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> retrieveAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement retrieveById(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipement introuvable : " + id));
    }

    @Override
    @Transactional
    public Equipement update(Long id, Equipement equipement) {
        Equipement existing = retrieveById(id);
        existing.setLibelle(equipement.getLibelle());
        existing.setVehicule(equipement.getVehicule());
        return equipementRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!equipementRepository.existsById(id)) {
            throw new EntityNotFoundException("Equipement introuvable : " + id);
        }
        equipementRepository.deleteById(id);
    }
}