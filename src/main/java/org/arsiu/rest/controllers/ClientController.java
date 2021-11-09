package org.arsiu.rest.controllers;

import org.arsiu.rest.exception.technique.not.found.TechniqueNotFoundException;
import org.arsiu.rest.models.Client;
import org.arsiu.rest.models.technique.Technique;
import org.arsiu.rest.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class ClientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody final Client client) {
        LOGGER.info("Added new technique");
        return new ResponseEntity<Client>(clientService.addClient(client), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Client> updateClient(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Client client) {

        if (clientService.getClientById(id) == null) {
            LOGGER.error("Can't put(updateClient) an client with non-existing id: " + id);
            throw new TechniqueNotFoundException("Can't put(updateClient) an client with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated client with id: " + id);
        client.setId(id);
        return new ResponseEntity<Client>(clientService.updateClient(client), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        LOGGER.info("Gave away all Clients");
        return new ResponseEntity<List<Client>>(clientService.getClients(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Client> getClient(@PathVariable(name = "id") final Integer id) {
        if (clientService.getClientById(id) == null) {
            LOGGER.error("Can't get(getClient) an client with non-existing id: " + id);
            throw new TechniqueNotFoundException("Can't get(getClient) an client with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an client with id: " + id);
        return new ResponseEntity<Client>(clientService.getClientById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Client> deleteClientById(@PathVariable("id") final Integer id) {
        if (clientService.getClientById(id) == null) {
            LOGGER.error("Can't delete(deleteClientById) an client with non-existing id: " + id);
            throw new TechniqueNotFoundException("Can't delete(deleteClientById) an client with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted client with id: " + id);
        clientService.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }
}
