package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.PublicationCategories;

@Data
@NoArgsConstructor

public class PublicationCategoriesModel {

    private Integer id_category;
    private String name_category;

    public static PublicationCategoriesModel toModel(PublicationCategories publicationCategories) {
        PublicationCategoriesModel model = new PublicationCategoriesModel();

        model.setId_category(publicationCategories.getId_category());
        model.setName_category((publicationCategories.getName_category()));

        return model;
    }
}