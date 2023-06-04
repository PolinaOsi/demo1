package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Tickets;

@Data
@NoArgsConstructor

public class TicketsModel {

    private Integer number_ticket;
    private Integer id_user;
    private Integer num_library;

    public static TicketsModel toModel(Tickets tickets) {
        TicketsModel model = new TicketsModel();

        model.setNumber_ticket(tickets.getNumber_ticket());
        model.setId_user((tickets.getId_user()));
        model.setNum_library(tickets.getNum_library());

        return model;
    }
}