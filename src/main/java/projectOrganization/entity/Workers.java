package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "Рабочие")

public class Workers {
        @Id
        @Column(name = "ID_рабочего")
        private Integer id_worker;
        @Column(name = "Место_работы", nullable = false)
        private String place_work;

        @OneToOne
        @JoinColumn(name = "id_user")
        private Users users;

        public Workers(Integer id_worker, String place_work) {
            this.id_worker = id_worker;
            this.place_work = place_work;
        }

        public Workers() { }

    public Integer getId_worker() { return id_worker; }

    public void setId_worker(Integer id_worker) { this.id_worker = id_worker; }

    public String getPlace_work() { return place_work; }

    public void setPlace_work(String place_work) { this.place_work = place_work; }

    public Users getUsers() { return users; }

    public void setUsers(Users users) { this.users = users; }
}

