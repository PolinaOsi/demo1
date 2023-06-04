package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.WorkersDTO;
import projectOrganization.models.WorkersModel;
import projectOrganization.services.WorkersService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/workers")
public class WorkersController {
        @Autowired
        private WorkersService workersService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllWorkers() {
            try {
                List<WorkersModel> workersModelList = new ArrayList<>();
                workersService.getAllWorkers().forEach(workers -> workersModelList.add(WorkersModel.toModel(workers)));
                return ResponseEntity.ok(workersModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{id_worker}")
        public ResponseEntity<?> getWorkers (@PathVariable Integer id_worker) {
            try {
                return ResponseEntity.ok(workersService.getWorkers(id_worker));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{id_worker}")
        public ResponseEntity<?> deleteWorkers(@PathVariable Integer id_worker) {
            try {
                workersService.deleteWorkers(id_worker);
                return ResponseEntity.ok("Рабочий удален");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?> addUserWorkers (@RequestBody WorkersDTO request) {
            try {
                workersService.addWorkers(request);
                return ResponseEntity.ok("Рабочий добавлен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
        public ResponseEntity<?> editUserWorkers (@RequestBody WorkersDTO request) {
            try {
                workersService.editWorkers(request);
                return ResponseEntity.ok("Рабочий изменен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }



