package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.ScientistDTO;
import projectOrganization.models.ScientistsModel;
import projectOrganization.services.ScientistService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/scientists")

public class ScientistsController {
        @Autowired
        private ScientistService scientistService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllScientists() {
            try {
                List<ScientistsModel> scientistsModelList = new ArrayList<>();
                scientistService.getAllScientists().forEach(scientists -> scientistsModelList.add(ScientistsModel.toModel(scientists)));
                return ResponseEntity.ok(scientistsModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{id_scientist}")
        public ResponseEntity<?> getScientists (@PathVariable Integer id_scientist) {
            try {
                return ResponseEntity.ok(scientistService.getScientists(id_scientist));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{id_scientist}")
        public ResponseEntity<?> deleteScientists (@PathVariable Integer id_scientist) {
            try {
                scientistService.deleteScientists(id_scientist);
                return ResponseEntity.ok("Научный работник удален");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?> addScientists (@RequestBody ScientistDTO request) {
            try {
                scientistService.addScientists(request);
                return ResponseEntity.ok("Научный работник добавлен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
        public ResponseEntity<?> editScientists (@RequestBody ScientistDTO request) {
            try {
                scientistService.editScientists(request);
                return ResponseEntity.ok("Научный работник изменен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }
