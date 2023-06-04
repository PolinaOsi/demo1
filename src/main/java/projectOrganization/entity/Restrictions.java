package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "Ограничения")

public class Restrictions {
        @Id
        @Column(name = "\"№_издания\"")
        private Integer num_publication;

        @Column(name = "Ограничение_на_выдачу")
        private Boolean restriction_lending;

        @Column(name = "Ограничение_срока_в_днях")
        private Integer restriction_days;

        @OneToOne(mappedBy = "restrictions")
        private Publications publications;

        public Restrictions(Integer num_publication, Boolean restriction_lending, Integer restriction_days) {
            this.num_publication = num_publication;
            this.restriction_lending = restriction_lending;
            this.restriction_days = restriction_days;
        }

        public Restrictions() { }

    public Integer getNum_publication() { return num_publication; }

    public void setNum_publication(Integer num_publication) { this.num_publication = num_publication; }

    public Boolean getRestriction_lending() { return restriction_lending; }

    public void setRestriction_lending(Boolean restriction_lending) { this.restriction_lending = restriction_lending; }

    public Integer getRestriction_days() { return restriction_days; }

    public void setRestriction_days(Integer restriction_days) { this.restriction_days = restriction_days; }

    public Publications getPublications() { return publications; }

    public void setPublications(Publications publications) { this.publications = publications; }
}



