package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Библиотеки")

public class Libraries {
    @Id
    @Column(name = "ID_библиотеки")
    private Integer id_library;

    @Column(name = "Название_библиотеки", nullable = false)
    private String name_library;

    @Column(name = "Адрес_библиотеки", nullable = false)
    private String address_library;

    @OneToMany(mappedBy = "id_employee")
    private List<Employees> employees;

    @OneToMany(mappedBy = "id_shelving")
    private List<Shelving> shelving;

    @OneToMany(mappedBy = "number")
    private List<ItemNumbers> itemNumbers;

    @OneToMany(mappedBy = "number_ticket")
    private List<Tickets> tickets;

    public Libraries(Integer id_library, String name_library, String address_library) {
        this.id_library = id_library;
        this.name_library = name_library;
        this.address_library = address_library;
    }

    public Libraries() { }

    public Integer getId_library() { return id_library; }

    public void setId_library(Integer id_library) { this.id_library = id_library; }

    public String getName_library() { return name_library; }

    public void setName_library(String name_library) { this.name_library = name_library; }

    public String getAddress_library() { return address_library; }

    public void setAddress_library(String address_library) { this.address_library = address_library; }

    public List<ItemNumbers> getItemNumbers() { return itemNumbers; }

    public void setItemNumbers(List<ItemNumbers> itemNumbers) { this.itemNumbers = itemNumbers; }

    public List<Employees> getEmployees() { return employees; }

    public void setEmployees(List<Employees> employees) { this.employees = employees; }

    public List<Tickets> getTickets() { return tickets; }

    public void setTickets(List<Tickets> tickets) { this.tickets = tickets; }

    public List<Shelving> getShelving() { return shelving; }

    public void setShelving(List<Shelving> shelving) { this.shelving = shelving; }
}
