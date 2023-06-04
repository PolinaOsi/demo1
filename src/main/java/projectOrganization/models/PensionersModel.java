package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Pensioners;

@Data
@NoArgsConstructor
public class PensionersModel {

    private Integer id_pensioner;
    private String pension;

    public static PensionersModel toModel(Pensioners pensioners) {
        PensionersModel model = new PensionersModel();

        model.setId_pensioner(pensioners.getId_pensioner());
        model.setPension((pensioners.getPension()));

        return model;
    }
}