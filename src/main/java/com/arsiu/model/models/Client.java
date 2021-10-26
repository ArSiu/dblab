package com.arsiu.model.models;

import com.arsiu.model.models.annotation.Column;
import com.arsiu.model.models.annotation.PrimaryKey;
import com.arsiu.model.models.annotation.Table;

import lombok.Data;

@Table(name = "client")
@Data
public class Client extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "phone_number_standart")
    private String phoneNumberStandart;

    @Column(name = "phone_number_formal")
    private String phoneNumberFormal;
}
