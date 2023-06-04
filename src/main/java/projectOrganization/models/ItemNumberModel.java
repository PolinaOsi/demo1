package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.ItemNumbers;

import java.util.Date;

@Data
@NoArgsConstructor
public class ItemNumberModel {

    private Integer number;
    private Integer id_publication;
    private Date date_import;
    private Date date_writeoff;
    private Integer num_library;

    public static ItemNumberModel toModel(ItemNumbers itemNumbers) {
        ItemNumberModel model = new ItemNumberModel();

        model.setNumber(itemNumbers.getNumber());
        model.setId_publication(itemNumbers.getId_publication());
        model.setDate_import(itemNumbers.getDate_import());
        model.setDate_writeoff(itemNumbers.getDate_writeoff());
        model.setNum_library(itemNumbers.getNum_library());

        return model;
    }
}
