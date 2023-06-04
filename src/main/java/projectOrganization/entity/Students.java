package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "Студенты")

public class Students {
    @Id
    @Column(name = "ID_студента")
    private Integer id_student;

    @Column(name = "Учебное_заведение", nullable = false)
    private String name_university;

    @Column(name = "Факультет", nullable = false)
    private String faculty;

    @Column(name = "Курс")
    private Integer num_course;

    @Column(name = "\"№_группы\"")
    private Integer num_group;

    @OneToOne
    @JoinColumn(name = "id_user")
    private Users users;

    public Students(Integer id_student, String name_university, String faculty, Integer num_course, Integer num_group) {
        this.id_student = id_student;
        this.name_university = name_university;
        this.faculty = faculty;
        this.num_course = num_course;
        this.num_group = num_group;
    }

    public Students() { }

    public Integer getId_student() { return id_student; }

    public void setId_student(Integer id_student) { this.id_student = id_student; }

    public String getName_university() { return name_university; }

    public void setName_university(String name_university) { this.name_university = name_university; }

    public String getFaculty() { return faculty; }

    public void setFaculty(String faculty) { this.faculty = faculty; }

    public Integer getNum_course() { return num_course; }

    public void setNum_course(Integer num_course) { this.num_course = num_course; }

    public Integer getNum_group() { return num_group; }

    public void setNum_group(Integer num_group) { this.num_group = num_group; }

    public Users getUsers() { return users; }

    public void setUsers(Users users) { this.users = users; }
}
