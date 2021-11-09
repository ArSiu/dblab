package org.arsiu.rest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="worker", schema="nova_poshta")
public class Worker extends GeneralModel{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "first_name")
    @NotNull(message = "Missing firstName")
    @Size(min=2, max=32)
    private String firstName;

    @Basic
    @Column(name = "last_name")
    @NotNull(message = "Missing lastName")
    @Size(min=2, max=32)
    private String lastName;

    @Basic
    @Column(name = "patronymic")
    @NotNull(message = "Missing patronymic")
    @Size(min=2, max=32)
    private String patronymic;

    @Basic
    @Column(name = "position")
    @NotNull(message = "Missing position")
    @Size(min=2, max=32)
    private String position;

    @Basic
    @Column(name = "salary")
    @NotNull(message = "Missing salary")
    @Min(1)
    @Max(999999)
    private Double salary;

    @Basic
    @Column(name = "passport_number")
    @NotNull(message = "Missing passportNumber")
    @Min(1)
    @Max(999999)
    private Integer passportNumber;

    @Basic
    @Column(name = "hirring_date")
    @NotNull(message = "Missing hirringDate")
    private String hirringDate;

    @Basic
    @Column(name = "working_hours")
    @NotNull(message = "Missing workingHours")
    @Min(1)
    @Max(999999)
    private Integer workingHours;

    @ManyToOne
    @JoinColumn(name = "post_office_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Missing postOfficeByPostOfficeId")
    private PostOffice postOfficeByPostOfficeId;

    public Worker(final String firstName, final String lastName, final String patronymic,
                  final String position, final Double salary, final Integer passportNumber, final String hirringDate,
                  final Integer workingHours, final PostOffice postOfficeByPostOfficeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.position = position;
        this.salary = salary;
        this.passportNumber = passportNumber;
        this.hirringDate = hirringDate;
        this.workingHours = workingHours;
        this.postOfficeByPostOfficeId = postOfficeByPostOfficeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id) && Objects.equals(firstName, worker.firstName) && Objects.equals(lastName, worker.lastName) && Objects.equals(patronymic, worker.patronymic) && Objects.equals(position, worker.position) && Objects.equals(salary, worker.salary) && Objects.equals(passportNumber, worker.passportNumber) && Objects.equals(hirringDate, worker.hirringDate) && Objects.equals(workingHours, worker.workingHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, patronymic, position, salary, passportNumber, hirringDate, workingHours);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-30s | %-30s | %-20s | %-20s | %-20s | %-20s | %-20s |",
                id,
                firstName,
                lastName,
                patronymic,
                position,
                salary,
                passportNumber,
                hirringDate,
                workingHours,
                postOfficeByPostOfficeId);
    }
}
