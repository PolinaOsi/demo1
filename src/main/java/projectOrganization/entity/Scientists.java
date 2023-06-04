package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Научные_работники")

public class Scientists {

        @Id
        @Column(name = "ID_научного_работника ")
        private Integer id_scientist;

        @Column(name = "Название_организации", nullable = false)
        private String name_organization;

        @Column(name = "Научная_тема", nullable = false)
        private String scientific_topic;

        @OneToOne
        @JoinColumn(name = "id_user")
        private Users users;


        public Scientists(Integer id_scientist, String name_organization, String scientific_topic) {
            this.id_scientist = id_scientist;
            this.name_organization = name_organization;
            this.scientific_topic = scientific_topic;
        }

        public Scientists() { }

    public Integer getId_scientist() { return id_scientist; }

    public void setId_scientist(Integer id_scientist) { this.id_scientist = id_scientist; }

    public String getName_organization() { return name_organization; }

    public void setName_organization(String name_organization) { this.name_organization = name_organization; }

    public String getScientific_topic() { return scientific_topic; }

    public void setScientific_topic(String scientific_topic) { this.scientific_topic = scientific_topic; }

    public Users getUsers() { return users; }

    public void setUsers(Users users) { this.users = users; }
}

