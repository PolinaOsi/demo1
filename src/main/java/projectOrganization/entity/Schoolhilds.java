package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "Школьники")

public class Schoolhilds {
    @Id
    @Column(name = "ID_школьника")
    private Integer id_schoolhild;

    @Column(name = "Название_школы ", nullable = false)
    private String name_school;

    @Column(name = "Класс")
    private Integer num_class;

    @Column(name = "Буква_класса", nullable = false)
    private String letter_lass;

    @OneToOne
    @JoinColumn(name = "id_user")
    private Users users;


    public Schoolhilds(Integer id_schoolhild, String name_school, Integer num_class, String letter_lass) {
        this.id_schoolhild = id_schoolhild;
        this.name_school = name_school;
        this.num_class = num_class;
        this.letter_lass = letter_lass;
    }

    public Schoolhilds() { }

    public Integer getId_schoolhild() { return id_schoolhild; }

    public void setId_schoolhild(Integer id_schoolhild) { this.id_schoolhild = id_schoolhild; }

    public String getName_school() { return name_school; }

    public void setName_school(String name_school) { this.name_school = name_school; }

    public Integer getNum_class() { return num_class; }

    public void setNum_class(Integer num_class) { this.num_class = num_class; }

    public String getLetter_lass() { return letter_lass; }

    public void setLetter_lass(String letter_lass) { this.letter_lass = letter_lass; }

    public Users getUsers() { return users; }

    public void setUsers(Users users) { this.users = users; }
}
