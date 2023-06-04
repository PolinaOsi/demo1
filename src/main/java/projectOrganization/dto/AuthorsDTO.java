package projectOrganization.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AuthorsDTO {
    private Integer id_author;
    private String surname;
    private String name;
    private String patronymic;
    private Date date_birth;
}
