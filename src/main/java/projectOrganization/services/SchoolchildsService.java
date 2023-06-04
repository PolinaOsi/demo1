package projectOrganization.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.SchoolchildsDTO;
import projectOrganization.entity.Schoolhilds;
import projectOrganization.repository.SchoolchildsRepository;

import java.util.List;
@Service
public class  SchoolchildsService {
    @Autowired
    private SchoolchildsRepository schoolchildsRepository;

    public List<Schoolhilds> getAllSchoolchilds() throws Exception {
        return (List<Schoolhilds>) schoolchildsRepository.findAll();
    }

    public Schoolhilds getSchoolchilds(Integer id_schoolhild) { return schoolchildsRepository.findById(id_schoolhild).get(); }

    public void addSchoolchilds(SchoolchildsDTO request) {
        Schoolhilds schoolhilds = new Schoolhilds();
        schoolhilds.setId_schoolhild(request.getId_schoolhild());
        schoolhilds.setName_school(request.getName_school());
        schoolhilds.setNum_class(request.getNum_class());
        schoolhilds.setLetter_lass(request.getLetter_lass());

        schoolchildsRepository.save(schoolhilds);
    }

    public void deleteSchoolchilds(Integer id_schoolhild) {
        Schoolhilds schoolhilds = schoolchildsRepository.findById(id_schoolhild).get();
        schoolchildsRepository.delete(schoolhilds);
    }

    public ResponseEntity<String> editSchoolchilds(@RequestBody SchoolchildsDTO schoolchildsDTO) {
        try {
            if(!schoolchildsRepository.existsById(schoolchildsDTO.getId_schoolhild())) {
                return ResponseEntity.badRequest().body("Школьника не существует");
            }

            Schoolhilds schoolhilds = new Schoolhilds(schoolchildsDTO.getId_schoolhild(), schoolchildsDTO.getName_school(), schoolchildsDTO.getNum_class(), schoolchildsDTO.getLetter_lass());
            schoolchildsRepository.save(schoolhilds);

            return ResponseEntity.ok("Успех");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}





