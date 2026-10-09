package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;

import java.util.List;

public interface IPaiementService {

    Paiement add(Paiement paiement);

    List<Paiement> retrieveAll();

    Paiement retrieveById(Long id);

    Paiement update(Long id, Paiement paiement);

    void delete(Long id);
}