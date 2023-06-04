package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Restrictions;

@Data
@NoArgsConstructor
public class RestrictionsModel {

    private Integer num_publication;
    private Boolean restriction_lending;
    private Integer restriction_days;

    public static RestrictionsModel toModel(Restrictions restrictions) {
        RestrictionsModel model = new RestrictionsModel();

        model.setNum_publication(restrictions.getNum_publication());
        model.setRestriction_lending((restrictions.getRestriction_lending()));
        model.setRestriction_days(restrictions.getRestriction_days());

        return model;
    }
}