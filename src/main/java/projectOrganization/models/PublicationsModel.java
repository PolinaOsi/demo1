package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Publications;

@Data
@NoArgsConstructor

public class PublicationsModel {

    private Integer id_publication;
    private String name;
    private Integer category;
    private Integer type;
    private Integer author;

    public static PublicationsModel toModel(Publications publications) {
        PublicationsModel model = new PublicationsModel();

        model.setId_publication(publications.getId_publication());
        model.setName((publications.getName()));
        model.setCategory(publications.getCategory());
        model.setType(publications.getType());
        model.setAuthor(publications.getAuthor());

        return model;
    }
}