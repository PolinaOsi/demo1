package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.UserCategories;

@Data
@NoArgsConstructor
public class UserCategoriesModel {

    private Integer id_category;
    private String name_category;

    public static UserCategoriesModel toModel(UserCategories userCategories) {
        UserCategoriesModel model = new UserCategoriesModel();

        model.setId_category(userCategories.getId_category());
        model.setName_category((userCategories.getName_category()));

        return model;
    }
}