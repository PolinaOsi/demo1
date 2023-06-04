package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.*;
import projectOrganization.models.PublicationsModel;
import projectOrganization.services.PublicationsService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/publications")

public class PublicationsController {
        @Autowired
        private PublicationsService publicationsService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllPublications() {
            try {
                List<PublicationsModel> publicationsModelList = new ArrayList<>();
                publicationsService.getAllPublications().forEach(publications -> publicationsModelList.add(PublicationsModel.toModel(publications)));
                return ResponseEntity.ok(publicationsModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{id_publication}")
        public ResponseEntity<?>  getPublications (@PathVariable Integer id_publication) {
            try {
                return ResponseEntity.ok(publicationsService.getPublications(id_publication));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{id_publication}")
        public ResponseEntity<?>  deletePublications(@PathVariable Integer id_publication) {
            try {
                publicationsService.deletePublications(id_publication);
                return ResponseEntity.ok("Издание удалено");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?>  addPublications(@RequestBody PublicationsDTO request ) {
            try {
                publicationsService.addPublications(request);
                return ResponseEntity.ok("Издание добавлено");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
        public ResponseEntity<?>  editPublications(@RequestBody PublicationsDTO request) {
            try {
                publicationsService.editPublications(request);
                return ResponseEntity.ok("Издание изменено");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }

