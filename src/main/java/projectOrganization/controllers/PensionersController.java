package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.PensionersDTO;
import projectOrganization.models.PensionersModel;
import projectOrganization.services.PensionersService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/pensioners")

public class PensionersController {
        @Autowired
        private PensionersService pensionersService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllPensioners() {
            try {
                List<PensionersModel> pensionersModelList = new ArrayList<>();
                pensionersService.getAllPensioners().forEach(pensioners -> pensionersModelList.add(PensionersModel.toModel(pensioners)));
                return ResponseEntity.ok(pensionersModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{id_pensioner}")
        public ResponseEntity<?> getPensioners (@PathVariable Integer id_pensioner) {
            try {
                return ResponseEntity.ok(pensionersService.getPensioners(id_pensioner));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{id_pensioner}")
        public ResponseEntity<?> deletePensioners(@PathVariable Integer id_pensioner) {
            try {
                pensionersService.deletePensioners(id_pensioner);
                return ResponseEntity.ok("Пенсионер удален");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?> addPensioners (@RequestBody PensionersDTO request) {
            try {
                pensionersService.addPensioners(request);
                return ResponseEntity.ok("Пенсионер добавлен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
        public ResponseEntity<?> editPensioners (@RequestBody PensionersDTO request) {
            try {
                pensionersService.editPensioners(request);
                return ResponseEntity.ok("Пенсионер изменен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }

