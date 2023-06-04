package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Читательские_билеты")
public class Tickets {
        @Id
        @Column(name = "\"№_билета\"")
        private Integer number_ticket;

        @Column(name = "ID_пользователя ")
        private Integer id_user;

        @Column(name = "\"№_библиотеки\"")
        private Integer num_library;

//        @ManyToMany
//        @JoinTable(name = "ticket_lend",
//                joinColumns = @JoinColumn (name = "num_ticket"),
//                inverseJoinColumns = @JoinColumn (name = "number_ticket"))
//        private List<Lending> lending;

        @ManyToOne
        @JoinColumn(name = "id_library")
        private Libraries libraries;

        @OneToOne
        @JoinColumn(name = "id_user")
        private Users users;

        public Tickets(Integer number_ticket, Integer id_user, Integer num_library) {
            this.number_ticket = number_ticket;
            this.id_user = id_user;
            this.num_library = num_library;
        }

        public Tickets() { }

    public Integer getNum_ticket() { return number_ticket; }

    public void setNum_ticket(Integer number_ticket) { this.number_ticket = number_ticket; }

    public Integer getId_user() { return id_user; }

    public void setId_user(Integer id_user) { this.id_user = id_user; }

    public Integer getNum_library() { return num_library; }

    public void setNum_library(Integer num_library) { this.num_library = num_library; }

//    public List<Lending> getLending() { return lending; }
//
//    public void setLending(List<Lending> lending) { this.lending = lending; }

    public Integer getNumber_ticket() { return number_ticket; }

    public void setNumber_ticket(Integer number_ticket) { this.number_ticket = number_ticket; }

    public Users getUsers() { return users; }

    public void setUsers(Users users) { this.users = users; }

    public Libraries getLibraries() { return libraries; }

    public void setLibraries(Libraries libraries) { this.libraries = libraries; }
}


