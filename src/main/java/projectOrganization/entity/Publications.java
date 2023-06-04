package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Издания")

public class Publications {
        @Id
        @Column(name = "ID_издания")
        private Integer id_publication;

        @Column(name = "Название", nullable = false)
        private String name;

        @Column(name = "Категория", nullable = false)
        private Integer category;

        @Column(name = "Тип", nullable = false)
        private Integer type;

        @Column(name = "Автор", nullable = false)
        private Integer author;

        @ManyToOne
        @JoinColumn (name = "ID_Автора")
        private Authors authors;

        @OneToMany(mappedBy = "number")
        private List<ItemNumbers> itemNumbers;

//            @ManyToOne
//            @JoinColumn(name = "id_shelving")
//            private LocationPublications locationPublications;

        @ManyToOne
        @JoinColumn(name = "id_category")
        private PublicationCategories publicationCategories;

        @ManyToOne
        @JoinColumn(name = "id_type")
        private PublicationTypes publicationTypes;

        @OneToOne
        @JoinColumn(name = "num_publication")
        private Restrictions restrictions;

        public Publications(Integer id_publication, String name, Integer category, Integer type, Integer author) {
            this.id_publication = id_publication;
            this.name = name;
            this.category = category;
            this.type = type;
            this.author = author;
        }

        public Publications() { }

    public Integer getId_publication() { return id_publication; }

    public void setId_publication(Integer id_publication) { this.id_publication = id_publication; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getCategory() { return category; }

    public void setCategory(Integer category) { this.category = category; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public Integer getAuthor() { return author; }

    public void setAuthor(Integer author) { this.author = author; }

    public List<ItemNumbers> getItemNumbers() { return itemNumbers; }

    public void setItemNumbers(List<ItemNumbers> itemNumbers) { this.itemNumbers = itemNumbers; }

    public Authors getAuthors() { return authors; }

    public void setAuthors(Authors authors) { this.authors = authors; }

//    public LocationPublications getLocationPublications() { return locationPublications; }
//
//    public void setLocationPublications(LocationPublications locationPublications) { this.locationPublications = locationPublications; }

    public PublicationCategories getPublicationCategories() { return publicationCategories; }

    public void setPublicationCategories(PublicationCategories publicationCategories) { this.publicationCategories = publicationCategories; }

    public PublicationTypes getPublicationTypes() { return publicationTypes; }

    public void setPublicationTypes(PublicationTypes publicationTypes) { this.publicationTypes = publicationTypes; }

    public Restrictions getRestrictions() { return restrictions; }

    public void setRestrictions(Restrictions restrictions) { this.restrictions = restrictions; }
}





