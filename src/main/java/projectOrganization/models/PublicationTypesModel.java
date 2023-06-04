package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.PublicationTypes;

@Data
@NoArgsConstructor
public class PublicationTypesModel {

    private Integer id_type;
    private String name_type;

    public static PublicationTypesModel toModel(PublicationTypes publicationTypes) {
        PublicationTypesModel model = new PublicationTypesModel();

        model.setId_type(publicationTypes.getId_type());
        model.setName_type((publicationTypes.getName_type()));

        return model;
    }
}