package org.arsiu.rest.controllers;

import org.arsiu.rest.dto.ClientDto;
import org.arsiu.rest.dto.DeliveryDto;
import org.arsiu.rest.exception.item.not.found.ItemNotFoundException;
import org.arsiu.rest.models.Client;
import org.arsiu.rest.models.Delivery;
import org.arsiu.rest.service.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/delivery")
public class DeliveryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryController.class);

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<DeliveryDto> createDelivery(@Valid @RequestBody final Delivery delivery) {
        LOGGER.info("Added new delivery");
        deliveryService.addDelivery(delivery);
        return new ResponseEntity<DeliveryDto>(new DeliveryDto(delivery), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DeliveryDto> updateDelivery(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Delivery delivery) {

        if (deliveryService.getDeliveryById(id) == null) {
            LOGGER.error("Can't put(updateDelivery) an delivery with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateDelivery) an delivery with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated delivery with id: " + id);
        delivery.setId(id);
        deliveryService.updateDelivery(delivery);
        return new ResponseEntity<DeliveryDto>(new DeliveryDto(delivery), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<DeliveryDto>> getDelivery() {
        LOGGER.info("Gave away all Delivery");
        List<Delivery> delivery = deliveryService.getDeliveries();
        List<DeliveryDto> deliveryDto = new ArrayList<>();
        for (Delivery del:delivery) {
            DeliveryDto deliveryDtos = new DeliveryDto(del);
            deliveryDto.add(deliveryDtos);
        }
        return new ResponseEntity<List<DeliveryDto>>(deliveryDto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DeliveryDto> getDelivery(@PathVariable(name = "id") final Integer id) {
        if (deliveryService.getDeliveryById(id) == null) {
            LOGGER.error("Can't get(getDelivery) an Delivery with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getDelivery) an Delivery with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an Delivery with id: " + id);
        return new ResponseEntity<DeliveryDto>(new DeliveryDto(deliveryService.getDeliveryById(id)), HttpStatus.OK);
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
