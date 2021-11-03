package com.arsiu.model.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="client", schema="nova_poshta")
public class Client extends GeneralModel {
    private Integer id;
    private String phoneNumberStandart;
    private String phoneNumberFormal;

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
    @Column(name = "phone_number_standart")
    public String getPhoneNumberStandart() {
        return phoneNumberStandart;
    }

    public void setPhoneNumberStandart(String phoneNumberStandart) {
        this.phoneNumberStandart = phoneNumberStandart;
    }

    @Basic
    @Column(name = "phone_number_formal")
    public String getPhoneNumberFormal() {
        return phoneNumberFormal;
    }

    public void setPhoneNumberFormal(String phoneNumberFormal) {
        this.phoneNumberFormal = phoneNumberFormal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(phoneNumberStandart, client.phoneNumberStandart) && Objects.equals(phoneNumberFormal, client.phoneNumberFormal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneNumberStandart, phoneNumberFormal);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s |",id,phoneNumberFormal,phoneNumberStandart);
    }
}
