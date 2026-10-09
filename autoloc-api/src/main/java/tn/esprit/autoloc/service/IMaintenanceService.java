package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;

public interface IMaintenanceService {

    Maintenance add(Maintenance maintenance);

    List<Maintenance> retrieveAll();

    Maintenance retrieveById(Long id);

    Maintenance update(Long id, Maintenance maintenance);

    void delete(Long id);
}