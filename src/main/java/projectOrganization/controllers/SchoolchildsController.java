package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.SchoolchildsDTO;
import projectOrganization.models.SchoolchildsModel;
import projectOrganization.services.SchoolchildsService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/schoolchilds")
public class SchoolchildsController {
    @Autowired
    private SchoolchildsService schoolchildsService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllSchoolchilds() {
        try {
            List<SchoolchildsModel> schoolchildsModelList = new ArrayList<>();
            schoolchildsService.getAllSchoolchilds().forEach(schoolhilds -> schoolchildsModelList.add(SchoolchildsModel.toModel(schoolhilds)));
            return ResponseEntity.ok(schoolchildsModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id_pensioner}")
    public ResponseEntity<?> getSchoolchilds (@PathVariable Integer id_schoolhild) {
        try {
            return ResponseEntity.ok(schoolchildsService.getSchoolchilds(id_schoolhild));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id_pensioner}")
    public ResponseEntity<?> deleteSchoolchilds (@PathVariable Integer id_schoolhild) {
        try {
            schoolchildsService.deleteSchoolchilds(id_schoolhild);
            return ResponseEntity.ok("Школьник удален");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSchoolchilds (@RequestBody SchoolchildsDTO request) {
        try {
            schoolchildsService.addSchoolchilds(request);
            return ResponseEntity.ok("Школьник добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editSchoolchilds (@RequestBody SchoolchildsDTO request) {
        try {
            schoolchildsService.editSchoolchilds(request);
            return ResponseEntity.ok("Школьник изменен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

