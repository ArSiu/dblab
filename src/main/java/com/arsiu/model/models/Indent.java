package com.arsiu.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="indent", schema="nova_poshta")
public class Indent extends GeneralModel{
    private Integer id;
    private String status;
    private Client clientBySenderId;
    private Client clientByReciverId;
    private Delivery deliveryByDeliveryId;

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
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indent indent = (Indent) o;
        return Objects.equals(id, indent.id) && Objects.equals(status, indent.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
    public Client getClientBySenderId() {
        return clientBySenderId;
    }

    public void setClientBySenderId(Client clientBySenderId) {
        this.clientBySenderId = clientBySenderId;
    }

    @ManyToOne
    @JoinColumn(name = "reciver_id", referencedColumnName = "id", nullable = false)
    public Client getClientByReciverId() {
        return clientByReciverId;
    }

    public void setClientByReciverId(Client clientByReciverId) {
        this.clientByReciverId = clientByReciverId;
    }

    @ManyToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "id", nullable = false)
    public Delivery getDeliveryByDeliveryId() {
        return deliveryByDeliveryId;
    }

    public void setDeliveryByDeliveryId(Delivery deliveryByDeliveryId) {
        this.deliveryByDeliveryId = deliveryByDeliveryId;
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s |",id,status,clientBySenderId, clientByReciverId, deliveryByDeliveryId);
    }
}
