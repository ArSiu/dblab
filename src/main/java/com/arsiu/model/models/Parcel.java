package com.arsiu.model.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="parcel", schema="nova_poshta")
public class Parcel extends GeneralModel{
    private Integer id;
    private Double price;
    private Double weight;
    private Date dateSend;
    private Date dateRecive;
    private String addressSender;
    private String addressReciver;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "weight")
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "dateSend")
    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    @Basic
    @Column(name = "dateRecive")
    public Date getDateRecive() {
        return dateRecive;
    }

    public void setDateRecive(Date dateRecive) {
        this.dateRecive = dateRecive;
    }

    @Basic
    @Column(name = "address_sender")
    public String getAddressSender() {
        return addressSender;
    }

    public void setAddressSender(String addressSender) {
        this.addressSender = addressSender;
    }

    @Basic
    @Column(name = "address_reciver")
    public String getAddressReciver() {
        return addressReciver;
    }

    public void setAddressReciver(String addressReciver) {
        this.addressReciver = addressReciver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return Objects.equals(id, parcel.id) && Objects.equals(price, parcel.price) && Objects.equals(weight, parcel.weight) && Objects.equals(dateSend, parcel.dateSend) && Objects.equals(dateRecive, parcel.dateRecive) && Objects.equals(addressSender, parcel.addressSender) && Objects.equals(addressReciver, parcel.addressReciver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, weight, dateSend, dateRecive, addressSender, addressReciver);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s | %-40s | %-40s |",
                id,
                price,
                weight,
                dateSend,
                dateRecive,
                addressSender,
                addressReciver);
    }
}
