package projectOrganization.dto;

import lombok.Data;

@Data
public class PublicationsOutDTO {
    private Integer id_publication;
    private String name;
    private Integer category;
    private Integer type;
    private Integer author;
}
