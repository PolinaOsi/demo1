package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Users;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@NoArgsConstructor
public class UsersModel {

    private Integer id_user;
    private Integer category;
    private String surname;
    private String name;
    private String patronymic;

    public static UsersModel toModel(Users users) {
        UsersModel model = new UsersModel();

        model.setId_user(users.getId_user());
        model.setCategory((users.getCategory()));
        model.setSurname(users.getSurname());
        model.setName(users.getName());
        model.setPatronymic(users.getPatronymic());

        return model;
    }
}