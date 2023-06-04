package projectOrganization.dto;
import lombok.Data;
@Data
public class EmployeesDTO {
    private Integer id_employee;
    private String surname;
    private String name;
    private String patronymic;
    private Integer number_library;
    private Integer number_hall;
}
