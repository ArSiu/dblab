package org.arsiu.rest.controllers;

import org.arsiu.rest.exception.technique.not.found.ItemNotFoundException;
import org.arsiu.rest.models.Parcel;
import org.arsiu.rest.service.ParcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/parcel")
public class ParcelController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParcelController.class);

    @Autowired
    private ParcelService parcelService;

    @PostMapping
    public ResponseEntity<Parcel> createParcel(@Valid @RequestBody final Parcel parcel) {
        LOGGER.info("Added new technique");
        return new ResponseEntity<Parcel>(parcelService.addParcel(parcel), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Parcel> updateParcel(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Parcel parcel) {

        if (parcelService.getParcelById(id) == null) {
            LOGGER.error("Can't put(updateParcel) an Parcel with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateParcel) an Parcel with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated Parcel with id: " + id);
        parcel.setId(id);
        return new ResponseEntity<Parcel>(parcelService.updateParcel(parcel), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Parcel>> getParcels() {
        LOGGER.info("Gave away all Parcels");
        return new ResponseEntity<List<Parcel>>(parcelService.getParcels(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Parcel> getParcel(@PathVariable(name = "id") final Integer id) {
        if (parcelService.getParcelById(id) == null) {
            LOGGER.error("Can't get(getParcel) an Parcel with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getParcel) an Parcel with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an Parcel with id: " + id);
        return new ResponseEntity<Parcel>(parcelService.getParcelById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Parcel> deleteParcelById(@PathVariable("id") final Integer id) {
        if (parcelService.getParcelById(id) == null) {
            LOGGER.error("Can't delete(deleteParcelById) an Parcel with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteParcelById) an Parcel with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted Parcel with id: " + id);
        parcelService.deleteParcelById(id);
        return ResponseEntity.noContent().build();
    }
}
