package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.PublicationTypesDTO;
import projectOrganization.models.PublicationTypesModel;
import projectOrganization.services.PublicationTypesService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/publicationTypes")

public class PublicationTypesController {
        @Autowired
        private PublicationTypesService publicationTypesService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllPublicationTypes() {
            try {
                List<PublicationTypesModel> publicationTypesModelList = new ArrayList<>();
                publicationTypesService.getAllPublicationTypes().forEach(publicationTypes -> publicationTypesModelList.add(PublicationTypesModel.toModel(publicationTypes)));
                return ResponseEntity.ok(publicationTypesModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{id_type}")
        public ResponseEntity<?> getPublicationTypes (@PathVariable Integer id_type) {
            try {
                return ResponseEntity.ok(publicationTypesService.getPublicationTypes(id_type));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{id_type}")
        public ResponseEntity<?> deletePublicationTypes(@PathVariable Integer id_type) {
            try {
                publicationTypesService.deletePublicationTypes(id_type);
                return ResponseEntity.ok("Тип изданий удален");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?> addPublicationTypes (@RequestBody PublicationTypesDTO request) {
            try {
                publicationTypesService.addPublicationTypes(request);
                return ResponseEntity.ok("Тип изданий добавлен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
        public ResponseEntity<?> editPublicationTypes (@RequestBody PublicationTypesDTO request) {
            try {
                publicationTypesService.editPublicationTypes(request);
                return ResponseEntity.ok("Тип изданий изменен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }



