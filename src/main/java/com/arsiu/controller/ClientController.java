package com.arsiu.controller;

import com.arsiu.model.DAO.ClientDao;
import com.arsiu.model.models.Client;
import com.arsiu.model.DAO.interfaces.GeneralDao;

import java.util.Objects;

public class ClientController implements com.arsiu.controller.interfaces.ClientController {

    private GeneralDao<Client, Integer> clientDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s |","id","phoneNumberFormal","phoneNumberStandart");
    }

    @Override
    public GeneralDao<Client, Integer> generalDao() {
        return Objects.requireNonNullElseGet(clientDao, () -> clientDao = new ClientDao());
    }

}
