package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "Пенсионеры")

public class Pensioners {
        @Id
        @Column(name = "ID_пенсионера ")
        private Integer id_pensioner;

        @Column(name = "Пенсионный ", nullable = false)
        private String pension;
        @OneToOne
        @JoinColumn(name = "id_user")
        private Users users;

        public Pensioners(Integer id_pensioner, String pension) {
            this.id_pensioner = id_pensioner;
            this.pension = pension;
        }

        public Pensioners() { }

    public Integer getId_pensioner() { return id_pensioner; }

    public void setId_pensioner(Integer id_pensioner) { this.id_pensioner = id_pensioner; }

    public String getPension() { return pension; }

    public void setPension(String pension) { this.pension = pension; }

    public Users getUsers() { return users; }

    public void setUsers(Users users) { this.users = users; }
}


