package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Scientists;

@Data
@NoArgsConstructor
public class ScientistsModel {

    private Integer id_scientist;
    private String name_organization;
    private String scientific_topic;

        public static ScientistsModel toModel(Scientists scientists) {
        ScientistsModel model = new ScientistsModel();

        model.setId_scientist(scientists.getId_scientist());
        model.setName_organization((scientists.getName_organization()));
        model.setScientific_topic(scientists.getScientific_topic());

        return model;
    }
}