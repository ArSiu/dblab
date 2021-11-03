package com.arsiu.controller;

import com.arsiu.model.DAO.interfaces.GeneralDao;
import com.arsiu.model.DAO.WorkerDao;
import com.arsiu.model.models.Worker;

import java.util.Objects;

public class WorkerController implements com.arsiu.controller.interfaces.WorkerController {

    private GeneralDao<Worker, Integer> workerDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-30s | %-30s | %-20s | %-20s | %-20s | %-20s | %-94s |",
                "id",
                "firstName",
                "lastName",
                "patronymic",
                "position",
                "salary",
                "passportNumber",
                "hirringDate",
                "workingHours",
                "postOfficeByPostOfficeId");
    }

    @Override
    public GeneralDao<Worker, Integer> generalDao() {
        return Objects.requireNonNullElseGet(workerDao, () -> workerDao = new WorkerDao());
    }
}
