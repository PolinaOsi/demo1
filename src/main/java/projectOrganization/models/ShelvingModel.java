package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Shelving;

@Data
@NoArgsConstructor

public class ShelvingModel {

    private Integer id_shelving;
    private Integer num_library;
    private Integer num_hall;
    private Integer num_shelving;

    public static ShelvingModel toModel(Shelving shelving) {
        ShelvingModel model = new ShelvingModel();

        model.setId_shelving(shelving.getId_shelving());
        model.setNum_library((shelving.getNum_library()));
        model.setNum_hall(shelving.getNum_hall());
        model.setNum_shelving(shelving.getNum_shelving());

        return model;
    }
}