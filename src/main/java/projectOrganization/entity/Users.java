package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Пользователи")

public class Users {
    @Id
    @Column(name = "ID_пользователя")
    private Integer id_user;

    @Column(name = "Категория", nullable = false)
    private Integer category;

    @Column(name = "Фамилия", nullable = false)
    private String surname;

    @Column(name = "Имя", nullable = false)
    private String name;

    @Column(name = "Отчество", nullable = false)
    private String patronymic;

    @ManyToOne
    @JoinColumn (name = "id_category")
    private UserCategories userCategories;

    @OneToOne (mappedBy = "users")
    private Teachers teachers;

    @OneToOne (mappedBy = "users")
    private Schoolhilds schoolhilds;

    @OneToOne (mappedBy = "users")
    private Students students;

    @OneToOne (mappedBy = "users")
    private Workers workers;

    @OneToOne(mappedBy = "users")
    private Pensioners pensioners;

    @OneToOne (mappedBy = "users")
    private Scientists scientists;

    @OneToOne(mappedBy = "users")
    private Tickets tickets;


    public Users(Integer id_user, Integer category, String surname, String name, String patronymic) {
        this.id_user = id_user;
        this.category = category;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Users() { }

    public Integer getCategory() { return category; }

    public void setCategory(Integer category) { this.category = category; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPatronymic() { return patronymic; }

    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public Integer getId_user() { return id_user; }

    public void setId_user(Integer id_user) { this.id_user = id_user; }

    public Schoolhilds getSchoolhilds() { return schoolhilds; }

    public void setSchoolhilds(Schoolhilds schoolhilds) { this.schoolhilds = schoolhilds; }

    public Pensioners getPensioners() { return pensioners; }

    public void setPensioners(Pensioners pensioners) { this.pensioners = pensioners; }

    public Scientists getScientists() { return scientists; }

    public void setScientists(Scientists scientists) { this.scientists = scientists; }

    public Students getStudents() { return students; }

    public void setStudents(Students students) { this.students = students; }

    public Teachers getTeachers() { return teachers; }

    public void setTeachers(Teachers teachers) { this.teachers = teachers; }

    public Tickets getTickets() { return tickets; }

    public void setTickets(Tickets tickets) { this.tickets = tickets; }

    public UserCategories getUserCategories() { return userCategories; }

    public void setUserCategories(UserCategories userCategories) { this.userCategories = userCategories; }

    public Workers getWorkers() { return workers; }

    public void setWorkers(Workers workers) { this.workers = workers; }
}
