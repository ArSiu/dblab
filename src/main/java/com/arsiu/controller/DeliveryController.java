package com.arsiu.controller;

import com.arsiu.model.DAO.interfaces.GeneralDao;
import com.arsiu.model.DAO.DeliveryDao;
import com.arsiu.model.models.Delivery;

import java.util.Objects;

public class DeliveryController implements com.arsiu.controller.interfaces.DeliveryController {

    private GeneralDao<Delivery, Integer> deliveryDao;

    @Override
    public GeneralDao<Delivery, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(deliveryDao, () -> deliveryDao = new DeliveryDao());
    }
}
