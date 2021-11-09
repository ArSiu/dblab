package org.arsiu.rest.controllers;

import org.arsiu.rest.exception.technique.not.found.TechniqueNotFoundException;
import org.arsiu.rest.models.Client;
import org.arsiu.rest.models.Indent;
import org.arsiu.rest.service.ClientService;
import org.arsiu.rest.service.IndentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/indent")
public class IndentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndentController.class);

    @Autowired
    private IndentService indentService;

    @PostMapping
    public ResponseEntity<Indent> createIndent(@Valid @RequestBody final Indent indent) {
        LOGGER.info("Added new technique");
        return new ResponseEntity<Indent>(indentService.addIndent(indent), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Indent> updateIndent(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Indent indent) {

        if (indentService.getIndentById(id) == null) {
            LOGGER.error("Can't put(updateIndent) an Indent with non-existing id: " + id);
            throw new TechniqueNotFoundException("Can't put(updateIndent) an Indent with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated Indent with id: " + id);
        indent.setId(id);
        return new ResponseEntity<Indent>(indentService.updateIndent(indent), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Indent>> getIndents() {
        LOGGER.info("Gave away all Indents");
        return new ResponseEntity<List<Indent>>(indentService.getIndents(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Indent> getIndent(@PathVariable(name = "id") final Integer id) {
        if (indentService.getIndentById(id) == null) {
            LOGGER.error("Can't get(getIndent) an Indent with non-existing id: " + id);
            throw new TechniqueNotFoundException("Can't get(getIndent) an Indent with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an client with id: " + id);
        return new ResponseEntity<Indent>(indentService.getIndentById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Indent> deleteIndentById(@PathVariable("id") final Integer id) {
        if (indentService.getIndentById(id) == null) {
            LOGGER.error("Can't delete(deleteIndentById) an Indent with non-existing id: " + id);
            throw new TechniqueNotFoundException("Can't delete(deleteIndentById) an Indent with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted Indent with id: " + id);
        indentService.deleteIndentById(id);
        return ResponseEntity.noContent().build();
    }
}
