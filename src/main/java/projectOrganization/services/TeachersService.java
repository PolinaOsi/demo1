package projectOrganization.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.TeachersDTO;
import projectOrganization.entity.Teachers;
import projectOrganization.repository.TeachersRepository;

import java.util.List;

@Service
public class TeachersService {
        @Autowired
        TeachersRepository teachersRepository;

        public List<Teachers> getAllTeachers() throws Exception {
            return (List<Teachers>) teachersRepository.findAll();
        }

        public Teachers getTeachers(Integer id_teacher) { return teachersRepository.findById(id_teacher).get(); }


        public void deleteTeachers(Integer id_teacher) {
            Teachers teachers = teachersRepository.findById(id_teacher).get();
            teachersRepository.delete(teachers);
        }

        public void addTeachers(TeachersDTO request) {
            Teachers teachers = new Teachers();
            teachers.setId_teacher(request.getId_teacher());
            teachers.setPlace_teaching(request.getPlace_teaching());
            teachers.setStatus(request.getStatus());

            teachersRepository.save(teachers);
        }

        public ResponseEntity<String> editTeachers(@RequestBody TeachersDTO teachersDTO) {
            try {
                if(!teachersRepository.existsById(teachersDTO.getId_teacher())) {
                    return ResponseEntity.badRequest().body("Преподавателя не существует");
                }

                Teachers teachers = new Teachers(teachersDTO.getId_teacher(), teachersDTO.getPlace_teaching(), teachersDTO.getStatus());
                teachersRepository.save(teachers);

                return ResponseEntity.ok("Успех");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Ошибка");
            }
        }
    }






