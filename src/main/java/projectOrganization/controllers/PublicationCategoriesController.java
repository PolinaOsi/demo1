package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.PublicationCategoriesDTO;
import projectOrganization.models.PublicationCategoriesModel;
import projectOrganization.services.PublicationCategoriesService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/publicationCategories")

public class PublicationCategoriesController {
        @Autowired
        private PublicationCategoriesService publicationCategoriesService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllPublicationCategories() {
            try {
                List<PublicationCategoriesModel> publicationCategoriesModelList = new ArrayList<>();
                publicationCategoriesService.getAllPublicationCategories().forEach(publicationCategories -> publicationCategoriesModelList.add(PublicationCategoriesModel.toModel(publicationCategories)));
                return ResponseEntity.ok(publicationCategoriesModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{id_category}")
        public ResponseEntity<?> getPublicationCategories (@PathVariable Integer id_category) {
            try {
                return ResponseEntity.ok(publicationCategoriesService.getPublicationCategories(id_category));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{id_category}")
        public ResponseEntity<?> deletePublicationCategories(@PathVariable Integer id_category) {
            try {
                publicationCategoriesService.deletePublicationCategories(id_category);
                return ResponseEntity.ok("Категория изданий удалена");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?> addPublicationCategories (@RequestBody PublicationCategoriesDTO request) {
            try {
                publicationCategoriesService.addPublicationCategories(request);
                return ResponseEntity.ok("Категория изданий добавлена");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
            public ResponseEntity<?> editPublicationCategories (@RequestBody PublicationCategoriesDTO request) {
            try {
                publicationCategoriesService.editPublicationCategories(request);
                return ResponseEntity.ok("Категория изданий изменена");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }


