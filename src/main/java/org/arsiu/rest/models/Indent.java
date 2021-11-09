package org.arsiu.rest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="indent", schema="nova_poshta")
public class Indent extends GeneralModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "post_office_from_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Missing postOfficeFromId")
    private PostOffice postOfficeFromId;

    @ManyToOne
    @JoinColumn(name = "post_office_to_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Missing postOfficeToId")
    private PostOffice postOfficeToId;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Missing clientBySenderId")
    private Client clientBySenderId;

    @ManyToOne
    @JoinColumn(name = "reciver_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Missing clientByReciverId")
    private Client clientByReciverId;

    @ManyToOne
    @JoinColumn(name = "parcel_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Missing parcel id")
    private Parcel parcelId;

    @ManyToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Missing deliveryByDeliveryId")
    private Delivery deliveryByDeliveryId;

    @Basic
    @Column(name = "status")
    @NotNull(message = "Missing status")
    @Size(min=2, max=62)
    private String status;

    public Indent(final Integer id, final PostOffice postOfficeFromId, final PostOffice postOfficeToId,
                  final Client clientBySenderId,final Client clientByReciverId, final Parcel parcelId,
                  final Delivery deliveryByDeliveryId, final String status) {
        this.id = id;
        this.postOfficeFromId = postOfficeFromId;
        this.postOfficeToId = postOfficeToId;
        this.clientBySenderId = clientBySenderId;
        this.clientByReciverId = clientByReciverId;
        this.parcelId = parcelId;
        this.deliveryByDeliveryId = deliveryByDeliveryId;
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

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s |",id,status,clientBySenderId, clientByReciverId, deliveryByDeliveryId);
    }
}
