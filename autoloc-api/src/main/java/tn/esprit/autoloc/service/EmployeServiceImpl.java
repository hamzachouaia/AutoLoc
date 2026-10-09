package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.IEmployeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final IEmployeRepository employeRepository;

    @Override
    public Employe add(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> retrieveAll() {
        return employeRepository.findAll();
    }

    @Override
    public Employe retrieveById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employe introuvable : " + id));
    }

    @Override
    @Transactional
    public Employe update(Long id, Employe employe) {
        Employe existing = retrieveById(id);
        existing.setNom(employe.getNom());
        existing.setPrenom(employe.getPrenom());
        existing.setRole(employe.getRole());
        existing.setAgence(employe.getAgence());
        return employeRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!employeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employe introuvable : " + id);
        }
        employeRepository.deleteById(id);
    }
}