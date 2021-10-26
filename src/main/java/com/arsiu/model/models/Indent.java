package com.arsiu.model.models;

import com.arsiu.model.models.annotation.Column;
import com.arsiu.model.models.annotation.PrimaryKey;
import com.arsiu.model.models.annotation.Table;
import lombok.Data;

@Table(name = "indent")
@Data
public class Indent extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "post_office_from_id")
    private Integer postOfficeFromId;

    @Column(name = "post_office_to_id")
    private Integer postOfficeToId;

    @Column(name = "sender_id")
    private Integer senderId;

    @Column(name = "reciver_id")
    private Integer reciverId;

    @Column(name = "parcel_id")
    private Integer parcelId;

    @Column(name = "delivery_id")
    private Integer deliveryId;

    @Column(name = "status")
    private String status;
}
