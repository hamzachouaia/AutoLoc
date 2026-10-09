package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.IReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final IReservationRepository reservationRepository;

    @Override
    public Reservation add(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> retrieveAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation introuvable : " + id));
    }

    @Override
    @Transactional
    public Reservation update(Long id, Reservation reservation) {
        Reservation existing = retrieveById(id);
        existing.setDateDebut(reservation.getDateDebut());
        existing.setDateFin(reservation.getDateFin());
        existing.setStatut(reservation.getStatut());
        existing.setVehicule(reservation.getVehicule());
        existing.setClient(reservation.getClient());
        return reservationRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new EntityNotFoundException("Reservation introuvable : " + id);
        }
        reservationRepository.deleteById(id);
    }
}