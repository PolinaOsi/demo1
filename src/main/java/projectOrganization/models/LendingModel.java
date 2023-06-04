package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Lending;

import java.util.Date;

@Data
@NoArgsConstructor
public class LendingModel {

    private Integer item_number_publication;
    private Integer num_ticket;
    private Date issue_date;
    private Date return_period;
    private Date return_date;
    private Integer num_employee;

    public static LendingModel toModel(Lending lending) {
        LendingModel model = new LendingModel();

        model.setItem_number_publication(lending.getItem_number_publication());
        model.setNum_ticket((lending.getNum_ticket()));
        model.setIssue_date(lending.getIssue_date());
        model.setReturn_period(lending.getReturn_period());
        model.setReturn_date(lending.getReturn_date());
        model.setNum_employee(lending.getNum_employee());

        return model;
    }
}
