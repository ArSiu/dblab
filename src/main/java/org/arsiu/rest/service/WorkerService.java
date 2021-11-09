package org.arsiu.rest.service;

import org.arsiu.rest.dal.WorkerRepository;
import org.arsiu.rest.models.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    public Worker addWorker(final Worker worker) {
        return workerRepository.save(worker);
    }

    public Worker updateWorker(final Worker worker) {
        return workerRepository.save(worker);
    }

    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }

    public Worker getWorkerById(final Integer id) {
        return workerRepository.findById(id).orElse(null);
    }

    public void deleteWorkerById(final Integer id) {
        workerRepository.deleteById(id);
    }
}
