package org.arsiu.rest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="parcel", schema="nova_poshta")
public class Parcel extends GeneralModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "price")
    @Min(1)
    @Max(999999)
    @NotNull(message = "Missing price")
    private Double price;

    @Basic
    @Column(name = "weight")
    @Min(1)
    @Max(999999)
    @NotNull(message = "Missing weight")
    private Double weight;

    @Basic
    @Column(name = "date_send")
    private Date dateSend;

    @Basic
    @Column(name = "date_recive")
    private Date dateRecive;

    @Basic
    @Column(name = "address_sender")
    @NotNull(message = "Missing addressSender")
    @Size(min=2, max=32)
    private String addressSender;

    @Basic
    @Column(name = "address_reciver")
    @NotNull(message = "Missing addressReciver")
    @Size(min=2, max=32)
    private String addressReciver;

    public Parcel(final Double price, final Double weight, final Date dateSend,
                  final Date dateRecive, final String addressSender, final String addressReciver) {
        this.price = price;
        this.weight = weight;
        this.dateSend = dateSend;
        this.dateRecive = dateRecive;
        this.addressSender = addressSender;
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
