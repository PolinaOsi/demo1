package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.UserCategoriesDTO;
import projectOrganization.models.UserCategoriesModel;
import projectOrganization.services.UserCategoriesService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/usersCategories")
public class UserCategoriesController {
    @Autowired
    private UserCategoriesService userCategoriesService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUserCategories() {
        try {
            List<UserCategoriesModel> userCategoriesModelList = new ArrayList<>();
            userCategoriesService.getAllUserCategories().forEach(userCategories -> userCategoriesModelList.add(UserCategoriesModel.toModel(userCategories)));
            return ResponseEntity.ok(userCategoriesModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id_category}")
    public ResponseEntity<?> getUserCategories (@PathVariable Integer id_category) {
        try {
            return ResponseEntity.ok(userCategoriesService.getUserCategories(id_category));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id_category}")
    public ResponseEntity<?> deleteUserCategories(@PathVariable Integer id_category) {
        try {
            userCategoriesService.deleteUserCategories(id_category);
            return ResponseEntity.ok("Категория пользователей удалена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUserCategories (@RequestBody UserCategoriesDTO request) {
        try {
            userCategoriesService.addUserCategories(request);
            return ResponseEntity.ok("Категория пользователей добавлена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editUserCategories (@RequestBody UserCategoriesDTO request) {
        try {
            userCategoriesService.editUserCategories(request);
            return ResponseEntity.ok("Категория пользователей изменена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}


