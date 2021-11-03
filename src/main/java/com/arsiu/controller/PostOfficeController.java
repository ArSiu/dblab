package com.arsiu.controller;

import com.arsiu.model.DAO.interfaces.GeneralDao;
import com.arsiu.model.DAO.PostOfficeDao;
import com.arsiu.model.models.PostOffice;

import java.util.Objects;

public class PostOfficeController implements com.arsiu.controller.interfaces.PostOfficeController {

    private GeneralDao<PostOffice, Integer>  postOfficeDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-20s |",
                "id",
                "name",
                "city",
                "address");
    }

    @Override
    public GeneralDao<PostOffice, Integer> generalDao() {
        return Objects.requireNonNullElseGet(postOfficeDao, () -> postOfficeDao = new PostOfficeDao());
    }
}
