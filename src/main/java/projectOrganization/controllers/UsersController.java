package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.*;
import projectOrganization.models.UsersModel;
import projectOrganization.services.UsersService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/users")
public class UsersController {
        @Autowired
        private UsersService usersService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllUsers() {
            try {
                List<UsersModel> usersModelList = new ArrayList<>();
                usersService.getAllUsers().forEach(users -> usersModelList.add(UsersModel.toModel(users)));
                return ResponseEntity.ok(usersModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{id_user}")
        public ResponseEntity<?>  getUsers (@PathVariable Integer id_user) {
            try {
                return ResponseEntity.ok(usersService.getUsers(id_user));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{id_user}")
        public ResponseEntity<?>  deleteUsers(@PathVariable Integer id_user) {
            try {
                usersService.deleteUsers(id_user);
                return ResponseEntity.ok("Пользователь удален");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?>  addUsers(@RequestBody UsersDTO request) {
            try {
                usersService.addUsers(request);
                return ResponseEntity.ok("Пользователь добавлен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
        public ResponseEntity<?>  editUsers(@RequestBody UsersDTO request) {
            try {
                usersService.editUsers(request);
                return ResponseEntity.ok("Пользователь изменен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

    }

