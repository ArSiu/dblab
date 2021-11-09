package org.arsiu.rest.service;

import org.arsiu.rest.dal.ClientRepository;
import org.arsiu.rest.dal.DeliveryRepository;
import org.arsiu.rest.models.Client;
import org.arsiu.rest.models.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery addDelivery(final Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery updateDelivery(final Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public List<Delivery> getDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(final Integer id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    public void deleteDeliveryById(final Integer id) {
        deliveryRepository.deleteById(id);
    }
}
