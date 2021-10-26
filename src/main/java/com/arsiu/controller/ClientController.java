package com.arsiu.controller;

import com.arsiu.model.DAO.ClientDao;
import com.arsiu.model.models.Client;
import com.arsiu.model.DAO.interfaces.GeneralDao;

import java.util.Objects;

public class ClientController implements com.arsiu.controller.interfaces.ClientController {

    private GeneralDao<Client, Integer> clientDao;

    @Override
    public GeneralDao<Client, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(clientDao, () -> clientDao = new ClientDao());
    }
}
