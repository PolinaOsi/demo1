package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Schoolhilds;

@Data
@NoArgsConstructor
public class SchoolchildsModel {

    private Integer id_schoolhild;
    private String name_school;
    private Integer num_class;
    private String letter_lass;

    public static SchoolchildsModel toModel(Schoolhilds schoolhilds) {
        SchoolchildsModel model = new SchoolchildsModel();

        model.setId_schoolhild(schoolhilds.getId_schoolhild());
        model.setName_school((schoolhilds.getName_school()));
        model.setNum_class(schoolhilds.getNum_class());
        model.setLetter_lass(schoolhilds.getLetter_lass());

        return model;
    }
}