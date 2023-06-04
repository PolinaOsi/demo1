package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "Преподаватели")

public class Teachers {
    @Id
    @Column(name = "ID_преподавателя")
    private Integer id_teacher;

    @Column(name = "Место_преподавания", nullable = false)
    private String place_teaching;

    @Column(name = "Статус", nullable = false)
    private String status;

    @OneToOne
    @JoinColumn(name = "id_user")
    private Users users;

    public Teachers(Integer id_teacher, String place_teaching, String status) {
        this.id_teacher = id_teacher;
        this.place_teaching = place_teaching;
        this.status = status;
    }

    public Teachers() { }

    public Integer getId_teacher() { return id_teacher; }

    public void setId_teacher(Integer id_teacher) { this.id_teacher = id_teacher; }

    public String getPlace_teaching() { return place_teaching; }

    public void setPlace_teaching(String place_teaching) { this.place_teaching = place_teaching; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Users getUsers() { return users; }

    public void setUsers(Users users) { this.users = users; }
}
