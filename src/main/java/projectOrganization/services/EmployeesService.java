package projectOrganization.services;
import projectOrganization.entity.Employees;
import projectOrganization.dto.EmployeesDTO;
import projectOrganization.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeesService {
    @Autowired
    EmployeesRepository employeesRepository;

    public List<Employees> getAllEmployees() throws Exception {
        return (List<Employees>) employeesRepository.findAll();
    }

    public Employees getEmployees(Integer id_employee) {
        return employeesRepository.findById(id_employee).get();
    }

    public void addEmployees(EmployeesDTO request) {
        Employees employee = new Employees();
        employee.setId_employee(request.getId_employee());
        employee.setSurname(request.getSurname());
        employee.setName(request.getName());
        employee.setPatronymic(request.getPatronymic());
        employee.setNumber_library(request.getNumber_library());
        employee.setNumber_hall(request.getNumber_hall());
        employeesRepository.save(employee);
    }

    public void deleteEmployees(Integer id_employee) {
        Employees employee = employeesRepository.findById(id_employee).get();
        employeesRepository.delete(employee);
    }

    public ResponseEntity<String> editEmployees(@RequestBody EmployeesDTO employeesDTO) {
        try {
            if(!employeesRepository.existsById(employeesDTO.getId_employee())) {
                return ResponseEntity.badRequest().body("Сотрудника не существует");
            }

            Employees employee = new Employees(employeesDTO.getId_employee(), employeesDTO.getSurname(),
                    employeesDTO.getName(), employeesDTO.getPatronymic(),
                    employeesDTO.getNumber_library(), employeesDTO.getNumber_hall());
            employeesRepository.save(employee);

            return ResponseEntity.ok("Успех");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
    public List<Employees> query(Integer num_lib, Integer num_hall) {
        return employeesRepository.query(num_lib, num_hall);
    }
}


