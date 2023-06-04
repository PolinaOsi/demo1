package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Students;

@Data
@NoArgsConstructor
public class StudentsModel {

    private Integer id_student;
    private String name_university;
    private String faculty;
    private Integer num_course;
    private Integer num_group;

    public static StudentsModel toModel(Students students) {
        StudentsModel model = new StudentsModel();

        model.setId_student(students.getId_student());
        model.setName_university((students.getName_university()));
        model.setFaculty(students.getFaculty());
        model.setNum_course(students.getNum_course());
        model.setNum_group(students.getNum_group());

        return model;
    }
}