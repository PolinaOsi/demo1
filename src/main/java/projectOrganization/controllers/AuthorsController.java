package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.AuthorsDTO;
import projectOrganization.models.AuthorsModel;
import projectOrganization.services.AuthorsService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/authors")

public class AuthorsController {
    @Autowired
    private AuthorsService authorsService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllAuthors() {
        try {
            List<AuthorsModel> authorsModelsList = new ArrayList<>();
            authorsService.getAllAuthors().forEach(authors -> authorsModelsList.add(AuthorsModel.toModel(authors)));
            return ResponseEntity.ok(authorsModelsList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id_author}")
    public ResponseEntity<?> getAuthors (@PathVariable Integer id_author) {
        try {
            return ResponseEntity.ok(authorsService.getAuthors(id_author));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id_author}")
    public ResponseEntity<?> deleteAuthors(@PathVariable Integer id_author) {
        try {
            authorsService.deleteAuthors(id_author);
            return ResponseEntity.ok("Автор удален");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAuthors (@RequestBody AuthorsDTO request) {
        try {
            authorsService.addAuthors(request);
            return ResponseEntity.ok("Автор добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editAuthors (@RequestBody AuthorsDTO request) {
        try {
            authorsService.editAuthors(request);
            return ResponseEntity.ok("Автор изменен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
