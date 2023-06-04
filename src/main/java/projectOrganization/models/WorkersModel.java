package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Workers;

@Data
@NoArgsConstructor
public class WorkersModel {

    private Integer id_worker;
    private String place_work;

    public static WorkersModel toModel(Workers workers) {
        WorkersModel model = new WorkersModel();

        model.setId_worker(workers.getId_worker());
        model.setPlace_work((workers.getPlace_work()));

        return model;
    }
}