package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Сотрудники")
public class Employees {
        @Id
        @Column(name = "ID_сотрудника")
        private Integer id_employee;

        @Column(name = "Фамилия", nullable = false)
        private String surname;

        @Column(name = "Имя", nullable = false)
        private String name;

        @Column(name = "Отчество", nullable = false)
        private String patronymic;

        @Column(name = "\"№_библиотеки\"", nullable = false)
        private Integer number_library;

        @Column(name = "\"№_зала\"")
        private Integer number_hall;

        @ManyToOne
        @JoinColumn (name = "id_library")
        private Libraries libraries;

//        @ManyToMany
//        @JoinTable(name = "empl_lend",
//            joinColumns = @JoinColumn (name = "id_employee"),
//            inverseJoinColumns = @JoinColumn (name = "num_employee"))
//        private List<Lending> lending;

    public Employees(Integer id_employee, String surname, String name,
                     String patronymic, Integer number_library, Integer number_hall) {
        this.id_employee = id_employee;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.number_library = number_library;
        this.number_hall = number_hall;
    }

    public Employees() { }

    public Integer getId_employee() {
        return id_employee;
    }

    public void setId_employee(Integer id_employee) {
        this.id_employee = id_employee;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public Integer getNumber_library() {
        return number_library;
    }

    public void setNumber_library(Integer number_library) {
        this.number_library = number_library;
    }

    public Integer getNumber_hall() {
        return number_hall;
    }

    public void setNumber_hall(Integer number_hall) {
        this.number_hall = number_hall;
    }

    public Libraries getLibraries() { return libraries; }

    public void setLibraries(Libraries libraries) { this.libraries = libraries; }
//
//    public List<Lending> getLending() { return lending; }
//
//    public void setLending(List<Lending> lending) { this.lending = lending; }
}
