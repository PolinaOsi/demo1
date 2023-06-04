package projectOrganization.keys;
import java.io.Serializable;
import java.util.Date;

public class LendingId implements Serializable {
    private Integer item_number_publication;
    private Integer num_ticket;
    private Integer num_employee;

    public LendingId() {};

    public LendingId(Integer item_number_publication, Integer num_ticket, Integer num_employee) {
        this.item_number_publication = item_number_publication;
        this.num_ticket = num_ticket;
        this.num_employee = num_employee;
    }
}
