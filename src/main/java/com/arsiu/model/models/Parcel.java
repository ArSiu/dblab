package com.arsiu.model.models;

import com.arsiu.model.models.annotation.Column;
import com.arsiu.model.models.annotation.PrimaryKey;
import com.arsiu.model.models.annotation.Table;
import lombok.Data;

@Table(name = "parcel")
@Data
public class Parcel extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "price")
    private Float price;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "dateSend")
    private String dataSend;

    @Column(name = "dateRecive")
    private String dateRecive;

    @Column(name = "address_sender")
    private String addressSender;

    @Column(name = "address_reciver")
    private String addressReciver;

}
