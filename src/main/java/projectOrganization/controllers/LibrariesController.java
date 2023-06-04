package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.*;
import projectOrganization.models.LibrariesModel;
import projectOrganization.services.LibrariesService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/libraries")

public class LibrariesController {
        @Autowired
        private LibrariesService librariesService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllLibraries() {
            try {
                List<LibrariesModel> librariesModelList = new ArrayList<>();
                librariesService.getAllLibraries().forEach(libraries -> librariesModelList.add(LibrariesModel.toModel(libraries)));
                return ResponseEntity.ok(librariesModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{id_library}")
        public ResponseEntity<?>  getLibraries (@PathVariable Integer id_library) {
            try {
                return ResponseEntity.ok(librariesService.getLibraries(id_library));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{id_library}")
        public ResponseEntity<?>  deleteLibraries(@PathVariable Integer id_library) {
            try {
                librariesService.deleteLibraries(id_library);
                return ResponseEntity.ok("Библиотека удалена");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?>  addLibraries(@RequestBody LibrariesDTO request ) {
            try {
                librariesService.addLibraries(request);
                return ResponseEntity.ok("Библиотека добавлена");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
        public ResponseEntity<?>  editLibraries(@RequestBody LibrariesDTO request) {
            try {
                librariesService.editLibraries(request);
                return ResponseEntity.ok("Библиотека изменена");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }

