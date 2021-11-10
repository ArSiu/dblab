package org.arsiu.rest.controllers;

import org.arsiu.rest.exception.technique.not.found.ItemNotFoundException;
import org.arsiu.rest.models.Delivery;
import org.arsiu.rest.service.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/delivery")
public class DeliveryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryController.class);

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@Valid @RequestBody final Delivery delivery) {
        LOGGER.info("Added new delivery");
        return new ResponseEntity<Delivery>(deliveryService.addDelivery(delivery), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Delivery> updateDelivery(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Delivery delivery) {

        if (deliveryService.getDeliveryById(id) == null) {
            LOGGER.error("Can't put(updateDelivery) an delivery with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateDelivery) an delivery with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated delivery with id: " + id);
        delivery.setId(id);
        return new ResponseEntity<Delivery>(deliveryService.updateDelivery(delivery), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Delivery>> getDelivery() {
        LOGGER.info("Gave away all Delivery");
        return new ResponseEntity<List<Delivery>>(deliveryService.getDeliveries(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Delivery> getDelivery(@PathVariable(name = "id") final Integer id) {
        if (deliveryService.getDeliveryById(id) == null) {
            LOGGER.error("Can't get(getDelivery) an Delivery with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getDelivery) an Delivery with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an Delivery with id: " + id);
        return new ResponseEntity<Delivery>(deliveryService.getDeliveryById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Delivery> deleteDeliveryById(@PathVariable("id") final Integer id) {
        if (deliveryService.getDeliveryById(id) == null) {
            LOGGER.error("Can't delete(deleteDeliveryById) an Delivery with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteDeliveryById) an Delivery with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted client with id: " + id);
        deliveryService.deleteDeliveryById(id);
        return ResponseEntity.noContent().build();
    }
}
