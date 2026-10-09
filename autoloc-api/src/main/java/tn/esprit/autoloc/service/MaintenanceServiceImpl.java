package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.IMaintenanceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance add(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> retrieveAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance retrieveById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maintenance introuvable : " + id));
    }

    @Override
    @Transactional
    public Maintenance update(Long id, Maintenance maintenance) {
        Maintenance existing = retrieveById(id);
        existing.setDateDebut(maintenance.getDateDebut());
        existing.setDateFin(maintenance.getDateFin());
        existing.setDescription(maintenance.getDescription());
        existing.setVehicule(maintenance.getVehicule());
        return maintenanceRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new EntityNotFoundException("Maintenance introuvable : " + id);
        }
        maintenanceRepository.deleteById(id);
    }
}