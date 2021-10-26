package com.arsiu.model.models;

import com.arsiu.model.models.annotation.Column;
import com.arsiu.model.models.annotation.PrimaryKey;
import com.arsiu.model.models.annotation.Table;
import lombok.Data;

@Table(name = "delivery")
@Data
public class Delivery extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "worker_id")
    private Integer workerId;

    @Column(name = "price")
    private Float price;

    @Column(name = "type")
    private String type;

    @Column(name = "max_weight")
    private Float maxWeight;

    @Column(name = "min_weight")
    private Float minWeight;
}
