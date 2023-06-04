package projectOrganization.controllers;

import projectOrganization.dto.EmployeesDTO;
import projectOrganization.entity.Employees;
import projectOrganization.models.EmployeesModel;
import projectOrganization.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/employees")
public class EmployeesController {
        @Autowired
        private EmployeesService employeesService;

        @GetMapping("/all")
        public ResponseEntity<?>  getAllEmployees() {
            try {
                List<EmployeesModel> employeesModelList = new ArrayList<>();
                employeesService.getAllEmployees().forEach(employee -> employeesModelList.add(EmployeesModel.toModel(employee)));
                return ResponseEntity.ok(employeesModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{id_employee}")
        public ResponseEntity<?>  getEmployees (@PathVariable Integer id_employee) {
            try {
                return ResponseEntity.ok(employeesService.getEmployees(id_employee));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{id_employee}")
        public ResponseEntity<?>  deleteEmployees(@PathVariable Integer id_employee) {
            try {
                employeesService.deleteEmployees(id_employee);
                return ResponseEntity.ok("Сотрудник удален");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?>  addEmployees(@RequestBody EmployeesDTO request ) {
            try {
                employeesService.addEmployees(request);
                return ResponseEntity.ok("Сотрудник добавлен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
        public ResponseEntity<?>  editEmployees(@RequestBody EmployeesDTO request) {
            try {
                employeesService.editEmployees(request);
                return ResponseEntity.ok("Сотрудник изменен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/q/{num_lib}/{num_hall}")
        public ResponseEntity<?>  query (@PathVariable Integer num_lib, @PathVariable Integer num_hall) {
            List<EmployeesModel> employeesModelList = new ArrayList<>();
            employeesService.query(num_lib, num_hall).forEach(employee -> employeesModelList.add(EmployeesModel.toModel(employee)));
            return ResponseEntity.ok(employeesModelList);
        }

}
