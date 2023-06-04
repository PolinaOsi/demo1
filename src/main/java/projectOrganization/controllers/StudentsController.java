package projectOrganization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectOrganization.dto.StudentsDTO;
import projectOrganization.entity.Students;
import projectOrganization.models.StudentsModel;
import projectOrganization.services.StudentsService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudents() {
        try {
            List<StudentsModel> studentsModelList = new ArrayList<>();
            studentsService.getAllStudents().forEach(students -> studentsModelList.add(StudentsModel.toModel(students)));
            return ResponseEntity.ok(studentsModelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id_student}")
    public ResponseEntity<?> getStudents (@PathVariable Integer id_student) {
        try {
            return ResponseEntity.ok(studentsService.getStudents(id_student));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id_student}")
    public ResponseEntity<?> deleteStudents (@PathVariable Integer id_student) {
        try {
            studentsService.deleteStudents(id_student);
            return ResponseEntity.ok("Студент удален");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudents (@RequestBody StudentsDTO request) {
        try {
            studentsService.addStudents(request);
            return ResponseEntity.ok("Студент добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editStudents (@RequestBody StudentsDTO request) {
        try {
            studentsService.editStudents(request);
            return ResponseEntity.ok("Школьник изменен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{name_university}/{faculty}")
    public List<Students> getAllStudentsByNameUniversityFaculty (@PathVariable String name_university, @PathVariable String faculty) {
        return studentsService.getAllStudentsByNameUniversityFaculty(name_university, faculty);
    }
}

