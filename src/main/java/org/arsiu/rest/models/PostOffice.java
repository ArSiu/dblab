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
@Table(name = "post_office", schema = "nova_poshta")
public class PostOffice extends GeneralModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name")
    @NotNull(message = "Missing name")
    @Size(min=2, max=32)
    private String name;

    @Basic
    @Column(name = "city")
    @NotNull(message = "Missing city")
    @Size(min=2, max=32)
    private String city;

    @Basic
    @Column(name = "address")
    @NotNull(message = "Missing address")
    @Size(min=2, max=32)
    private String address;

    public PostOffice(final String name, final String city, final String address) {
        this.name = name;
        this.city = city;
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
