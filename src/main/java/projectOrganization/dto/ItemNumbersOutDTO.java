package projectOrganization.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ItemNumbersOutDTO {
    private Integer number;
    private Integer id_publication;
    private Date date_import;
    private Date date_writeoff;
    private Integer num_library;
}
