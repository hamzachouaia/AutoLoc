package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation add(Reservation reservation);

    List<Reservation> retrieveAll();

    Reservation retrieveById(Long id);

    Reservation update(Long id, Reservation reservation);

    void delete(Long id);
}