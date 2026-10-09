package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;

import java.util.List;

public interface IEmployeService {

    Employe add(Employe employe);

    List<Employe> retrieveAll();

    Employe retrieveById(Long id);

    Employe update(Long id, Employe employe);

    void delete(Long id);
}