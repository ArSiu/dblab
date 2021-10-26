package com.arsiu.controller;

import com.arsiu.model.DAO.interfaces.GeneralDao;
import com.arsiu.model.DAO.WorkerDao;
import com.arsiu.model.models.Worker;

import java.util.Objects;

public class WorkerController implements com.arsiu.controller.interfaces.WorkerController {

    private GeneralDao<Worker, Integer> workerDao;

    @Override
    public GeneralDao<Worker, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(workerDao,() -> workerDao = new WorkerDao());
    }
}
