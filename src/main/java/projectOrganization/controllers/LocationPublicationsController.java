package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.*;
import projectOrganization.models.LocationPublicationsModel;
import projectOrganization.services.LocationPublicationsService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/locationPublications")

public class LocationPublicationsController {
        @Autowired
        private LocationPublicationsService locationPublicationsService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllLocationPublications() {
            try {
                List<LocationPublicationsModel> locationPublicationsModelList = new ArrayList<>();
                locationPublicationsService.getAllLocationPublications().forEach(locationPublications -> locationPublicationsModelList.add(LocationPublicationsModel.toModel(locationPublications)));
                return ResponseEntity.ok(locationPublicationsModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{id_publication}/{id_shelving}/{num_shelf}")
        public ResponseEntity<?> getLocationPublications (@PathVariable Integer id_publication, @PathVariable Integer id_shelving, @PathVariable Integer num_shelf) {
            try {
                return ResponseEntity.ok(locationPublicationsService.getLocationPublications(id_publication, id_shelving, num_shelf));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{id_publication}/{id_shelving}/{num_shelf}")
        public ResponseEntity<?> deleteLocationPublications(@PathVariable Integer id_publication, @PathVariable Integer id_shelving, @PathVariable Integer num_shelf) {
            try {
                locationPublicationsService.deleteLocationPublications(id_publication, id_shelving, num_shelf);
                return ResponseEntity.ok("Раположение изданий удалено");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?> addLocationPublications(@RequestBody LocationPublicationDTO request ) {
            try {
                locationPublicationsService.addLocationPublications(request);
                return ResponseEntity.ok("Раположение изданий добавлено");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
        public ResponseEntity<?> editLocationPublications(@RequestBody LocationPublicationDTO request) {
            try {
                locationPublicationsService.editLocationPublications(request);
                return ResponseEntity.ok("Раположение изданий изменено");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

    }

