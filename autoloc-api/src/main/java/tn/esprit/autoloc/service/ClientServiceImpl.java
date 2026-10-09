package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.IClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;

    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> retrieveAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client retrieveById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable : " + id));
    }

    @Override
    @Transactional
    public Client update(Long id, Client client) {
        Client existing = retrieveById(id);
        existing.setNom(client.getNom());
        existing.setPrenom(client.getPrenom());
        existing.setEmail(client.getEmail());
        existing.setTelephone(client.getTelephone());
        existing.setNumPermis(client.getNumPermis());
        existing.setDateInscription(client.getDateInscription());
        return clientRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Client introuvable : " + id);
        }
        clientRepository.deleteById(id);
    }
}