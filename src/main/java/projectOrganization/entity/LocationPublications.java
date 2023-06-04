package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;
import projectOrganization.keys.LocationPublicationsId;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@IdClass(LocationPublicationsId.class)
@Table(name = "Расположение_изданий")

public class LocationPublications {
        @Id
        @Column(name = "ID_издания")
        private Integer id_publication;

        @Id
        @Column(name = "ID_стеллажа")
        private Integer id_shelving;

        @Id
        @Column(name = "\"№_полки\"")
        private Integer num_shelf;

//        @OneToMany(mappedBy = "id_publication")
//        private List<Publications> publications;

//        @OneToMany(mappedBy = "id_shelving")
//        private List<Shelving> shelving;


        public LocationPublications(Integer id_publication, Integer id_shelving, Integer num_shelf) {
            this.id_publication = id_publication;
            this.id_shelving = id_shelving;
            this.num_shelf = num_shelf;
        }

        public LocationPublications() { }

    public Integer getId_publication() { return id_publication; }

    public void setId_publication(Integer id_publication) { this.id_publication = id_publication; }

    public Integer getId_shelving() { return id_shelving; }

    public void setId_shelving(Integer id_shelving) { this.id_shelving = id_shelving; }

    public Integer getNum_shelf() { return num_shelf; }

    public void setNum_shelf(Integer num_shelf) { this.num_shelf = num_shelf; }

//    public List<Publications> getPublications() { return publications; }
//
//    public void setPublications(List<Publications> publications) { this.publications = publications; }

//    public List<Shelving> getShelving() { return shelving; }
//
//    public void setShelving(List<Shelving> shelving) { this.shelving = shelving; }
}


