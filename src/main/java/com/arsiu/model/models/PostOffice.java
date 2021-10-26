package com.arsiu.model.models;

import com.arsiu.model.models.annotation.Column;
import com.arsiu.model.models.annotation.PrimaryKey;
import com.arsiu.model.models.annotation.Table;
import lombok.Data;

@Table(name = "post_office")
@Data
public class PostOffice extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;
}
