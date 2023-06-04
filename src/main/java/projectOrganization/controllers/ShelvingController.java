package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.ShelvingDTO;
import projectOrganization.models.ShelvingModel;
import projectOrganization.services.ShelvingService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/shelving")

public class ShelvingController {
    @Autowired
    private ShelvingService shelvingService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllShelving() {
        try {
            List<ShelvingModel> shelvingModelList = new ArrayList<>();
            shelvingService.getAllShelving().forEach(shelving -> shelvingModelList.add(ShelvingModel.toModel(shelving)));
            return ResponseEntity.ok(shelvingModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id_shelving}")
    public ResponseEntity<?> getShelving(@PathVariable Integer id_shelving) {
        try {
            return ResponseEntity.ok(shelvingService.getShelving(id_shelving));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id_shelving}")
    public ResponseEntity<?> deleteShelving(@PathVariable Integer id_shelving) {
        try {
            shelvingService.deleteShelving(id_shelving);
            return ResponseEntity.ok("Стеллаж удален");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addShelving(@RequestBody ShelvingDTO request) {
        try {
            shelvingService.addShelving(request);
            return ResponseEntity.ok("Стеллаж добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editShelving(@RequestBody ShelvingDTO request) {
        try {
            shelvingService.editShelving(request);
            return ResponseEntity.ok("Стеллаж изменен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}


