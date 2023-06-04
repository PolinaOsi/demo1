package projectOrganization.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.RestrictionsDTO;
import projectOrganization.entity.Restrictions;
import projectOrganization.repository.RestrictionsRepository;

import java.util.List;

@Service
public class RestrictionsService {
    @Autowired
    RestrictionsRepository restrictionsRepository;

    public List<Restrictions> getAllRestrictions() throws Exception {
        return (List<Restrictions>) restrictionsRepository.findAll();
    }

    public Restrictions getRestrictions(Integer num_publication) { return restrictionsRepository.findById(num_publication).get(); }

    public void addRestrictions(RestrictionsDTO request) {
        Restrictions restrictions = new Restrictions();
        restrictions.setNum_publication(request.getNum_publication());
        restrictions.setRestriction_lending(request.getRestriction_lending());
        restrictions.setRestriction_days(request.getRestriction_days());

        restrictionsRepository.save(restrictions);
    }

    public void deleteRestrictions(Integer num_publication) {
        Restrictions restrictions = restrictionsRepository.findById(num_publication).get();
        restrictionsRepository.delete(restrictions);
    }

    public ResponseEntity<String> editRestrictions(@RequestBody RestrictionsDTO restrictionsDTO) {
        try {
            if(!restrictionsRepository.existsById(restrictionsDTO.getNum_publication())) {
                return ResponseEntity.badRequest().body("Огранчиения не существует");
            }

            Restrictions restrictions = new Restrictions(restrictionsDTO.getNum_publication(), restrictionsDTO.getRestriction_lending(), restrictionsDTO.getRestriction_days());
            restrictionsRepository.save(restrictions);

            return ResponseEntity.ok("Успех");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}





