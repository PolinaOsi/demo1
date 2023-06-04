package projectOrganization.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LendingOutDTO {
    private Integer item_number_publication;
    private Integer num_ticket;
    private Date issue_date;
    private Date return_period;
    private Date return_date;
    private Integer num_employee;
}
