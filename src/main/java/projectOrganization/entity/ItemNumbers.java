package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Номенклатурные_номера")

public class ItemNumbers {
        @Id
        @Column(name = "\"№\"")
        private Integer number;
        @Column(name = "ID_издания")
        private Integer id_publication;
        @Column(name = "Дата_привоза", nullable = false)
        private Date date_import;
        @Column(name = "Дата_списания")
        private Date date_writeoff;

        @Column(name = "\"№_библиотеки\"")
        private Integer num_library;

        @ManyToOne
        @JoinColumn(name = "id_publication")
        private Publications publications;

        @ManyToOne
        @JoinColumn(name = "id_library")
        private Libraries libraries;

//        @ManyToMany
//        @JoinTable(name = "num_lend",
//                joinColumns = @JoinColumn (name = "item_number_publication"),
//                inverseJoinColumns = @JoinColumn (name = "number"))
//        private List<Lending> lending;

        public ItemNumbers(Integer number, Integer id_publication, Date date_import, Date date_writeoff, Integer num_library) {
            this.number = number;
            this.id_publication = id_publication;
            this.date_import = date_import;
            this.date_writeoff = date_writeoff;
            this.num_library = num_library;
        }

        public ItemNumbers() { }

        public Integer getNumber() { return number; }

        public void setNumber(Integer number) { this.number = number; }

        public Integer getId_publication() { return id_publication; }

        public void setId_publication(Integer id_publication) { this.id_publication = id_publication; }

        public Date getDate_import() { return date_import; }

        public void setDate_import(Date date_import) { this.date_import = date_import; }

        public Date getDate_writeoff() { return date_writeoff; }

        public void setDate_writeoff(Date date_writeoff) { this.date_writeoff = date_writeoff; }

        public Integer getNum_library() { return num_library; }

        public void setNum_library(Integer num_library) { this.num_library = num_library; }

        public Publications getPublications() { return publications; }

        public void setPublications(Publications publications) { this.publications = publications; }

//        public List<Lending> getLending() { return lending; }
//
//        public void setLending(List<Lending> lending) { this.lending = lending; }

        public Libraries getLibraries() { return libraries; }

        public void setLibraries(Libraries libraries) { this.libraries = libraries; }
}





