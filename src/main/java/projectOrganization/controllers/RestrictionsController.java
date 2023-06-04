package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.RestrictionsDTO;
import projectOrganization.models.RestrictionsModel;
import projectOrganization.services.RestrictionsService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/restrictions")
public class RestrictionsController {
    @Autowired
    private RestrictionsService restrictionsService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllRestrictions() {
        try {
            List<RestrictionsModel> restrictionsModelList = new ArrayList<>();
            restrictionsService.getAllRestrictions().forEach(restrictions -> restrictionsModelList.add(RestrictionsModel.toModel(restrictions)));
            return ResponseEntity.ok(restrictionsModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id_restrictions}")
    public ResponseEntity<?> getRestrictions (@PathVariable Integer num_publication) {
        try {
            return ResponseEntity.ok(restrictionsService.getRestrictions(num_publication));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id_restrictions}")
    public ResponseEntity<?> deleteRestrictions(@PathVariable Integer num_publication) {
        try {
            restrictionsService.deleteRestrictions(num_publication);
            return ResponseEntity.ok("Огранчиение удалено");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRestrictions (@RequestBody RestrictionsDTO request) {
        try {
            restrictionsService.addRestrictions(request);
            return ResponseEntity.ok("Огранчиение добавлено");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editRestrictions (@RequestBody RestrictionsDTO request) {
        try {
            restrictionsService.editRestrictions(request);
            return ResponseEntity.ok("Огранчиение изменено");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

