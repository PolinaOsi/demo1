package projectOrganization.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.ScientistDTO;
import projectOrganization.entity.Scientists;
import projectOrganization.repository.ScientistsRepository;

import java.util.List;
@Service
public class ScientistService {
    @Autowired
    ScientistsRepository scientistsRepository;

    public List<Scientists> getAllScientists() throws Exception {
        return (List<Scientists>) scientistsRepository.findAll();
    }

    public Scientists getScientists(Integer id_scientist) { return scientistsRepository.findById(id_scientist).get(); }

    public void addScientists(ScientistDTO request) {
        Scientists scientists = new Scientists();
        scientists.setId_scientist(request.getId_scientist());
        scientists.setName_organization(request.getName_organization());
        scientists.setScientific_topic(request.getScientific_topic());

        scientistsRepository.save(scientists);
    }

    public void deleteScientists(Integer id_scientist) {
        Scientists scientists = scientistsRepository.findById(id_scientist).get();
        scientistsRepository.delete(scientists);
    }

    public ResponseEntity<String> editScientists(@RequestBody ScientistDTO scientistDTO) {
        try {
            if(!scientistsRepository.existsById(scientistDTO.getId_scientist())) {
                return ResponseEntity.badRequest().body("Научного работника не существует");
            }

            Scientists scientists = new Scientists(scientistDTO.getId_scientist(), scientistDTO.getName_organization(), scientistDTO.getScientific_topic());
            scientistsRepository.save(scientists);

            return ResponseEntity.ok("Успех");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}





