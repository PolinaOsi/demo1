package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Стеллажи")

public class Shelving {
        @Id
        @Column(name = "ID_стеллажа ")
        private Integer id_shelving;

        @Column(name = "\"№_библиотеки\"")
        private Integer num_library;

        @Column(name = "\"№_зала\"", nullable = false)
        private Integer num_hall;

        @Column(name = "\"№_стеллажа\"", nullable = false)
        private Integer num_shelving;

        @ManyToOne
        @JoinColumn(name = "id_library")
        private Libraries libraries;

//        @ManyToOne
//        @JoinColumn(name = "id_shelving")
//        private LocationPublications locationPublications;

        public Shelving(Integer id_shelving, Integer num_library, Integer num_hall, Integer num_shelving) {
            this.id_shelving = id_shelving;
            this.num_library = num_library;
            this.num_hall = num_hall;
            this.num_shelving = num_shelving;
        }

        public Shelving() { }

    public Integer getId_shelving() { return id_shelving; }

    public void setId_shelving(Integer id_shelving) { this.id_shelving = id_shelving; }

    public Integer getNum_library() { return num_library; }

    public void setNum_library(Integer num_library) { this.num_library = num_library; }

    public Integer getNum_hall() { return num_hall; }

    public void setNum_hall(Integer num_hall) { this.num_hall = num_hall; }

    public Integer getNum_shelving() { return num_shelving; }

    public void setNum_shelving(Integer num_shelving) { this.num_shelving = num_shelving; }

    public Libraries getLibraries() { return libraries; }

    public void setLibraries(Libraries libraries) { this.libraries = libraries; }

//    public LocationPublications getLocationPublications() { return locationPublications; }
//
//    public void setLocationPublications(LocationPublications locationPublications) { this.locationPublications = locationPublications; }
}

