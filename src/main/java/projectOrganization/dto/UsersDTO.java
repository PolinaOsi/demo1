package projectOrganization.dto;

import lombok.Data;

@Data
public class UsersDTO {
    private Integer id_user;
    private Integer category;
    private String surname;
    private String name;
    private String patronymic;
}
