package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;

import java.util.List;

public interface IAgenceService {

    Agence add(Agence agence);

    List<Agence> retrieveAll();

    Agence retrieveById(Long id);

    Agence update(Long id, Agence agence);

    void delete(Long id);
}