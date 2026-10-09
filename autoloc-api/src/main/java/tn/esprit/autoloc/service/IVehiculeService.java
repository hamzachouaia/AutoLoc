package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {

    Vehicule add(Vehicule vehicule);

    List<Vehicule> retrieveAll();

    Vehicule retrieveById(Long id);

    Vehicule update(Long id, Vehicule vehicule);

    void delete(Long id);
}