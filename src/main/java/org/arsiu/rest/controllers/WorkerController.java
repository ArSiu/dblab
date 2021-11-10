package org.arsiu.rest.controllers;

import org.arsiu.rest.exception.technique.not.found.ItemNotFoundException;
import org.arsiu.rest.models.Worker;
import org.arsiu.rest.service.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/worker")
public class WorkerController {
    private static final Logger LOGGER = LoggerFactory.getLogger( WorkerController.class);

    @Autowired
    private WorkerService workerService;

    @PostMapping
    public ResponseEntity<Worker> createClient(@Valid @RequestBody final Worker worker) {
        LOGGER.info("Added new worker");
        return new ResponseEntity<Worker>(workerService.addWorker(worker), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Worker> updateWorker(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Worker worker) {

        if (workerService.getWorkerById(id) == null) {
            LOGGER.error("Can't put(updateWorker) an Worker with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateWorker) an Worker with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated Worker with id: " + id);
        worker.setId(id);
        return new ResponseEntity<Worker>(workerService.updateWorker(worker), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Worker>> getWorkers() {
        LOGGER.info("Gave away all Worker");
        return new ResponseEntity<List<Worker>>(workerService.getWorkers(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Worker> getWorker(@PathVariable(name = "id") final Integer id) {
        if (workerService.getWorkerById(id) == null) {
            LOGGER.error("Can't get(getWorker) an Worker with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getWorker) an Worker with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an Worker with id: " + id);
        return new ResponseEntity<Worker>(workerService.getWorkerById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Worker> deleteWorkerById(@PathVariable("id") final Integer id) {
        if (workerService.getWorkerById(id) == null) {
            LOGGER.error("Can't delete(deleteWorkerById) an Worker with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteWorkerById) an Worker with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted Worker with id: " + id);
        workerService.deleteWorkerById(id);
        return ResponseEntity.noContent().build();
    }
}
