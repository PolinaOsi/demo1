package projectOrganization.dto;

import lombok.Data;

@Data
public class StudentsOutDTO {
    private Integer id_student;
    private String name_university;
    private String faculty;
    private Integer num_course;
    private Integer num_group;
}
