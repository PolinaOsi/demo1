package projectOrganization.dto;

import lombok.Data;

@Data
public class RestrictionsDTO {
    private Integer num_publication;
    private Boolean restriction_lending;
    private Integer restriction_days;
}
