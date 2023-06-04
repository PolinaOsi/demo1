package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Libraries;

@Data
@NoArgsConstructor

public class LibrariesModel {

    private Integer id_library;
    private String name_library;
    private String address_library;

    public static LibrariesModel toModel(Libraries libraries) {
        LibrariesModel model = new LibrariesModel();

        model.setId_library(libraries.getId_library());
        model.setName_library((libraries.getName_library()));
        model.setAddress_library(libraries.getAddress_library());

        return model;
    }
}
