package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;

public interface IClientService {

    Client add(Client client);

    List<Client> retrieveAll();

    Client retrieveById(Long id);

    Client update(Long id, Client client);

    void delete(Long id);
}