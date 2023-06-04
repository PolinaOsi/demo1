package projectOrganization.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.WorkersDTO;
import projectOrganization.entity.Workers;
import projectOrganization.repository.WorkersRepository;

import java.util.List;

@Service

public class WorkersService {
        @Autowired
        WorkersRepository workersRepository;

        public List<Workers> getAllWorkers() throws Exception {
            return (List<Workers>) workersRepository.findAll();
        }

        public Workers getWorkers(Integer id_worker) { return workersRepository.findById(id_worker).get(); }

        public void addWorkers(WorkersDTO request) {
            Workers workers = new Workers();
            workers.setId_worker(request.getId_worker());
            workers.setPlace_work(request.getPlace_work());

            workersRepository.save(workers);
        }

        public void deleteWorkers(Integer id_worker) {
            Workers workers = workersRepository.findById(id_worker).get();
            workersRepository.delete(workers);
        }

        public ResponseEntity<String> editWorkers(@RequestBody WorkersDTO workersDTO) {
            try {
                if(!workersRepository.existsById(workersDTO.getId_worker())) {
                    return ResponseEntity.badRequest().body("Рабочего не существует");
                }

                Workers workers = new Workers(workersDTO.getId_worker(), workersDTO.getPlace_work());
                workersRepository.save(workers);

                return ResponseEntity.ok("Успех");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Ошибка");
            }
        }
    }






