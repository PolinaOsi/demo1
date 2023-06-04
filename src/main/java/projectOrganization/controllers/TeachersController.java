package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.TeachersDTO;
import projectOrganization.models.TeachersModel;
import projectOrganization.services.TeachersService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/teachers")
public class TeachersController {
        @Autowired
        private TeachersService teachersService;

        @GetMapping("/all")
        public ResponseEntity<?> getAllTeachers() {
            try {
                List<TeachersModel> teachersModelList = new ArrayList<>();
                teachersService.getAllTeachers().forEach(teachers -> teachersModelList.add(TeachersModel.toModel(teachers)));
                return ResponseEntity.ok(teachersModelList);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/{id_teacher}")
        public ResponseEntity<?> getTeachers (@PathVariable Integer id_teacher) {
            try {
                return ResponseEntity.ok(teachersService.getTeachers(id_teacher));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{id_teacher}")
        public ResponseEntity<?> deleteTeachers(@PathVariable Integer id_teacher) {
            try {
                teachersService.deleteTeachers(id_teacher);
                return ResponseEntity.ok("Преподаватель удален");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/add")
        public ResponseEntity<?> addTeachers (@RequestBody TeachersDTO request) {
            try {
                teachersService.addTeachers(request);
                return ResponseEntity.ok("Преподаватель добавлен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PostMapping("/edit")
        public ResponseEntity<?> editTeachers (@RequestBody TeachersDTO request) {
            try {
                teachersService.editTeachers(request);
                return ResponseEntity.ok("Преподаватель изменен");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }


