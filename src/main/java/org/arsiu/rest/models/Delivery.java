package org.arsiu.rest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="delivery", schema="nova_poshta")
public class Delivery extends GeneralModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "worker_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Missing workerId")
    private Worker workerId;

    @Basic
    @Column(name = "price")
    @NotNull(message = "Missing price")
    @Min(1)
    @Max(999999)
    private Double price;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @NotNull(message = "Missing type (enum)")
    private Type type;

    @Basic
    @Column(name = "max_weight")
    @NotNull(message = "Missing maxWeight")
    @Min(1)
    @Max(999999)
    private Double maxWeight;

    @Basic
    @Column(name = "min_weight")
    @NotNull(message = "Missing minWeight")
    @Min(1)
    @Max(999999)
    private Double minWeight;

    public Delivery(final Worker workerId, final Double price,
                    final Type type, final Double maxWeight, final Double minWeight) {
        this.workerId = workerId;
        this.price = price;
        this.type = type;
        this.maxWeight = maxWeight;
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
