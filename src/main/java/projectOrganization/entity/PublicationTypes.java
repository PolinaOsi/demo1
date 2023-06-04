package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Типы_изданий")
public class PublicationTypes {
        @Id
        @Column(name = "ID_типа")
        private Integer id_type;

        @Column(name = "Название_типа", nullable = false)
        private String name_type;

        @OneToMany(mappedBy = "id_publication")
        private List<Publications> publications;

        public PublicationTypes(Integer id_type, String name_type) {
            this.id_type = id_type;
            this.name_type = name_type;
        }

        public PublicationTypes() { }

    public Integer getId_type() { return id_type; }

    public void setId_type(Integer id_type) { this.id_type = id_type; }

    public String getName_type() { return name_type; }

    public void setName_type(String name_type) { this.name_type = name_type; }

    public List<Publications> getPublications() { return publications; }

    public void setPublications(List<Publications> publications) { this.publications = publications; }
}



