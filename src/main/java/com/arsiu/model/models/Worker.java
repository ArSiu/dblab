package com.arsiu.model.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="worker", schema="nova_poshta")
public class Worker extends GeneralModel{
    private Integer id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String position;
    private Double salary;
    private Integer passportNumber;
    private Date hirringDate;
    private Integer workingHours;
    private PostOffice postOfficeByPostOfficeId;

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
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "salary")
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "passport_number")
    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Basic
    @Column(name = "hirring_date")
    public Date getHirringDate() {
        return hirringDate;
    }

    public void setHirringDate(Date hirringDate) {
        this.hirringDate = hirringDate;
    }

    @Basic
    @Column(name = "working_hours")
    public Integer getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Integer workingHours) {
        this.workingHours = workingHours;
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

    @ManyToOne
    @JoinColumn(name = "post_office_id", referencedColumnName = "id", nullable = false)
    public PostOffice getPostOfficeByPostOfficeId() {
        return postOfficeByPostOfficeId;
    }

    public void setPostOfficeByPostOfficeId(PostOffice postOfficeByPostOfficeId) {
        this.postOfficeByPostOfficeId = postOfficeByPostOfficeId;
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
