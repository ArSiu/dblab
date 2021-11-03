package com.arsiu.controller;

import com.arsiu.model.DAO.interfaces.GeneralDao;
import com.arsiu.model.DAO.ParcelDao;
import com.arsiu.model.models.Parcel;

import java.util.Objects;

public class ParcelController implements com.arsiu.controller.interfaces.ParcelController {

    private GeneralDao<Parcel, Integer> parcelDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s | %-40s | %-40s |",
                "id",
                "price",
                "weight",
                "dateSend",
                "dateRecive",
                "addressSender",
                "addressReciver");
    }

    @Override
    public GeneralDao<Parcel, Integer> generalDao() {
        return Objects.requireNonNullElseGet(parcelDao, () -> parcelDao = new ParcelDao());
    }
}
