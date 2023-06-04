package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Authors;

import java.util.Date;

@Data
@NoArgsConstructor
public class AuthorsModel {

    private Integer id_author;
    private String surname;
    private String name;
    private String patronymic;
    private Date date_birth;

    public static AuthorsModel toModel(Authors authors) {
        AuthorsModel model = new AuthorsModel();

        model.setId_author(authors.getId_author());
        model.setSurname(authors.getSurname());
        model.setName(authors.getName());
        model.setPatronymic(authors.getPatronymic());
        model.setDate_birth(authors.getDate_birth());
        return model;
    }
}
