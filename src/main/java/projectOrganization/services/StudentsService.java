package projectOrganization.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.StudentsDTO;
import projectOrganization.entity.Students;
import projectOrganization.repository.StudentsRepository;

import java.util.List;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    public List<Students> getAllStudents() throws Exception {
        return (List<Students>) studentsRepository.findAll();
    }

    public Students getStudents(Integer id_student) { return studentsRepository.findById(id_student).get(); }

    public void addStudents(StudentsDTO request) {
        Students students = new Students();
        students.setId_student(request.getId_student());
        students.setName_university(request.getName_university());
        students.setFaculty(request.getFaculty());
        students.setNum_course(request.getNum_course());
        students.setNum_group(request.getNum_group());

        studentsRepository.save(students);
    }

    public void deleteStudents(Integer id_student) {
        Students students = studentsRepository.findById(id_student).get();
        studentsRepository.delete(students);
    }

    public ResponseEntity<String> editStudents(@RequestBody StudentsDTO studentsDTO) {
        try {
            if(!studentsRepository.existsById(studentsDTO.getId_student())) {
                return ResponseEntity.badRequest().body("Студента не существует");
            }

            Students students = new Students(studentsDTO.getId_student(), studentsDTO.getName_university(), studentsDTO.getFaculty(), studentsDTO.getNum_course(), studentsDTO.getNum_group());
            studentsRepository.save(students);

            return ResponseEntity.ok("Успех");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    public List<Students> getAllStudentsByNameUniversityFaculty(String name_university, String faculty) {
        return studentsRepository.getAllStudentsByNameUniversityFaculty(name_university, faculty);
    }
}






