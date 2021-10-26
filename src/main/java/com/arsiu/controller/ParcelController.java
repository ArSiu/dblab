package com.arsiu.controller;

import com.arsiu.model.DAO.interfaces.GeneralDao;
import com.arsiu.model.DAO.ParcelDao;
import com.arsiu.model.models.Parcel;

import java.util.Objects;

public class ParcelController implements com.arsiu.controller.interfaces.ParcelController {

    private GeneralDao<Parcel, Integer> parcelDao;

    @Override
    public GeneralDao<Parcel, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(parcelDao,() -> parcelDao = new ParcelDao());
    }
}
