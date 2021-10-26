package com.arsiu.model.models;

import com.arsiu.model.models.annotation.Column;
import com.arsiu.model.models.annotation.PrimaryKey;
import com.arsiu.model.models.annotation.Table;
import lombok.Data;


@Table(name = "worker")
@Data
public class Worker extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "post_office_id")
    private Integer postOfficeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private Float salary;

    @Column(name = "passport_number")
    private Integer passportNumber;

    @Column(name = "hirring_date")
    private String hirringDate;

    @Column(name = "working_hours")
    private Integer workingHours;
}
