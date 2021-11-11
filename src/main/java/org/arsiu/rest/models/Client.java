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
@Table(name="client", schema="nova_poshta")
public class Client extends GeneralModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "phone_number_standart")
    @NotNull(message = "Missing phoneNumberStandart")
    @Size(min=3, max=50)
    private String phoneNumberStandart;

    @Basic
    @Column(name = "phone_number_formal")
    @NotNull(message = "Missing phoneNumberFormal")
    @Size(min=3, max=50)
    private String phoneNumberFormal;

    public Client(final String phoneNumberStandart, final String phoneNumberFormal) {
        this.phoneNumberStandart = phoneNumberStandart;
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
