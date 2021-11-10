package org.arsiu.rest.dto;

import org.arsiu.rest.models.Client;
import org.arsiu.rest.models.Delivery;
import org.arsiu.rest.models.Type;
import org.arsiu.rest.models.Worker;

public class DeliveryDto {
    private Delivery delivery;

    public DeliveryDto(Delivery delivery) {
        this.delivery = delivery;
    }

    public Integer getId() {
        return delivery.getId();
    }

    public Worker getWorkerId() {
        return delivery.getWorkerId();
    }

    public Double getPrice() {
        return delivery.getPrice();
    }

    public Type getType() {
        return delivery.getType();
    }

    public Double getMaxWeight() {
        return delivery.getMaxWeight();
    }

    public Double getMinWeight() {
        return delivery.getMinWeight();
    }
}
