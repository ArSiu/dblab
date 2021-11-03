package com.arsiu.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_office", schema = "nova_poshta")
public class PostOffice extends GeneralModel{
    private Integer id;
    private String name;
    private String city;
    private String address;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostOffice that = (PostOffice) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(city, that.city) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, address);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-40s |",
                id,
                name,
                city,
                address);
    }
}
