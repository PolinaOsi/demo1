package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Категории_изданий ")

public class PublicationCategories {
        @Id
        @Column(name = "ID_категории")
        private Integer id_category;

        @Column(name = "Название_категории", nullable = false)
        private String name_category;

        @OneToMany(mappedBy = "id_publication")
        private List<Publications> publications;

        public PublicationCategories(Integer id_category, String name_category) {
            this.id_category = id_category;
            this.name_category = name_category;
        }

        public PublicationCategories() { }

        public Integer getId_category() { return id_category; }

        public void setId_category(Integer id_category) { this.id_category = id_category; }

        public String getName_category() { return name_category; }

        public void setName_category(String name_category) { this.name_category = name_category; }

        public List<Publications> getPublications() { return publications; }

        public void setPublications(List<Publications> publications) { this.publications = publications; }
}


