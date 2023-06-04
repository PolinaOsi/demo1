package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.*;
import projectOrganization.models.LendingModel;
import projectOrganization.services.LendingService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/lending")

public class LendingController {
    @Autowired
    private LendingService lendingService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllLending() {
        try {
            List<LendingModel> lendingModelList = new ArrayList<>();
            lendingService.getAllLending().forEach(lending -> lendingModelList.add(LendingModel.toModel(lending)));
            return ResponseEntity.ok(lendingModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{item_number_publication}/{num_ticket}/{num_employee}")
    public ResponseEntity<?> getLending (@PathVariable Integer item_number_publication, @PathVariable Integer num_ticket, @PathVariable Integer num_employee) {
        try {
            return ResponseEntity.ok(lendingService.getLending(item_number_publication, num_ticket, num_employee));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{item_number_publication}/{num_ticket}/{num_employee}")
    public ResponseEntity<?> deleteLending(@PathVariable Integer item_number_publication, @PathVariable Integer num_ticket, @PathVariable Integer num_employee) {
        try {
            lendingService.deleteLending(item_number_publication, num_ticket, num_employee);
            return ResponseEntity.ok("Запись выдачи удалена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addLending(@RequestBody LendingDTO request ) {
        try {
            lendingService.addLending(request);
            return ResponseEntity.ok("Запись выдачи добавлена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editLending(@RequestBody LendingDTO request) {
        try {
            lendingService.editLending(request);
            return ResponseEntity.ok("Запись выдачи изменена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
