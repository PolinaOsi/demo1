package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Teachers;

@Data
@NoArgsConstructor
public class TeachersModel {

    private Integer id_teacher;
    private String place_teaching;
    private String status;

    public static TeachersModel toModel(Teachers teachers) {
        TeachersModel model = new TeachersModel();

        model.setId_teacher(teachers.getId_teacher());
        model.setPlace_teaching((teachers.getPlace_teaching()));
        model.setStatus(teachers.getStatus());

        return model;
    }
}