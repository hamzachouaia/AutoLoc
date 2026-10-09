package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;

import java.util.List;

public interface IEquipementService {

    Equipement add(Equipement equipement);

    List<Equipement> retrieveAll();

    Equipement retrieveById(Long id);

    Equipement update(Long id, Equipement equipement);

    void delete(Long id);
}