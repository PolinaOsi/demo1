package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.LocationPublications;

@Data
@NoArgsConstructor

public class LocationPublicationsModel {

    private Integer id_publication;
    private Integer id_shelving;
    private Integer num_shelf;

    public static LocationPublicationsModel toModel(LocationPublications locationPublications) {
        LocationPublicationsModel model = new LocationPublicationsModel();

        model.setId_publication(locationPublications.getId_publication());
        model.setId_shelving((locationPublications.getId_shelving()));
        model.setNum_shelf(locationPublications.getNum_shelf());

        return model;
    }
}