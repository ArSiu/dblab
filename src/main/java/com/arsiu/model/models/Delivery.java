package com.arsiu.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="delivery", schema="nova_poshta")
public class Delivery extends GeneralModel{

    private Integer id;
    private Worker workerId;
    private Double price;
    private Type type;
    private Double maxWeight;
    private Double minWeight;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "worker_id", referencedColumnName = "id", nullable = false)
    public Worker getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Worker workerId) {
        this.workerId=workerId;
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
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public Type getType() {
        return type;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public void setType(Type type) {
        this.type = type;
    }

    @Basic
    @Column(name = "max_weight")
    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Basic
    @Column(name = "min_weight")
    public Double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Double minWeight) {
        this.minWeight = minWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id) && Objects.equals(price, delivery.price) && Objects.equals(type, delivery.type) && Objects.equals(maxWeight, delivery.maxWeight) && Objects.equals(minWeight, delivery.minWeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, type, maxWeight, minWeight);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s | %-20s |",id,workerId,price,type,maxWeight,minWeight);
    }
}
