package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Авторы")

public class Authors {
        @Id
        @Column(name = "ID_Автора")
        private Integer id_author;
        @Column(name = "Фамилия", nullable = false)
        private String surname;
        @Column(name = "Имя", nullable = false)
        private String name;
        @Column(name = "Отчество", nullable = false)
        private String patronymic;
        @Column (name = "Дата_рождения")
        private Date date_birth;

        @OneToMany (mappedBy = "id_publication")
        private List<Publications> publications;

        public Authors(Integer id_author, String surname, String name, String patronymic, Date date_birth) {
            this.id_author = id_author;
            this.surname = surname;
            this.name = name;
            this.patronymic = patronymic;
            this.date_birth = date_birth;
        }

        public Authors() { }

    public Integer getId_author() { return id_author; }

    public void setId_author(Integer id_author) { this.id_author = id_author; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPatronymic() { return patronymic; }

    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public Date getDate_birth() { return date_birth; }

    public void setDate_birth(Date date_birth) { this.date_birth = date_birth; }

    public List<Publications> getPublications() { return publications; }

    public void setPublications(List<Publications> publications) { this.publications = publications; }
}




