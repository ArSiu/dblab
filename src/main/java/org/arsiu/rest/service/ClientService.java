package org.arsiu.rest.service;

import org.arsiu.rest.dao.ClientRepository;
import org.arsiu.rest.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client addClient(final Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(final Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(final Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    public void deleteClientById(final Integer id) {
        clientRepository.deleteById(id);
    }
}
