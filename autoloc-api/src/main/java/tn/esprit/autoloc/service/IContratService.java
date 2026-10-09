package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;

import java.util.List;

public interface IContratService {

    Contrat add(Contrat contrat);

    List<Contrat> retrieveAll();

    Contrat retrieveById(Long id);

    Contrat update(Long id, Contrat contrat);

    void delete(Long id);
}