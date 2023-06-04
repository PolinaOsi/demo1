package projectOrganization.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import projectOrganization.entity.Employees;

@Data
@NoArgsConstructor
public class EmployeesModel {
    private Integer id_employee;
    private String surname;
    private String name;
    private String patronymic;
    private Integer number_library;
    private Integer number_hall;

    public static EmployeesModel toModel(Employees employee) {
        EmployeesModel model = new EmployeesModel();
        model.setId_employee(employee.getId_employee());
        model.setSurname(employee.getSurname());
        model.setName(employee.getName());
        model.setPatronymic(employee.getPatronymic());
        model.setNumber_library(employee.getNumber_library());
        model.setNumber_hall(employee.getNumber_hall());

        return model;
    }
}
