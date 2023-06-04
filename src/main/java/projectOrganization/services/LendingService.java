package projectOrganization.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.LendingDTO;
import projectOrganization.entity.Lending;
import projectOrganization.keys.LendingId;
import projectOrganization.repository.LendingRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Service
public class LendingService {
    @Autowired
    LendingRepository lendingRepository;

    public List<Lending> getAllLending() throws Exception {
        return (List<Lending>) lendingRepository.findAll();
    }

    public Lending getLending(Integer item_number_publication, Integer num_ticket, Integer num_employee) {
        LendingId id = new LendingId(item_number_publication, num_ticket, num_employee);
        return lendingRepository.findById(id).get();
    }

    public void addLending(LendingDTO request) {
        Lending lending = new Lending();
        lending.setItem_number_publication(request.getItem_number_publication());
        lending.setNum_ticket(request.getNum_ticket());
        lending.setIssue_date(request.getIssue_date());
        lending.setReturn_period(request.getReturn_period());
        lending.setReturn_date(request.getReturn_date());
        lending.setNum_employee(request.getNum_employee());
        lendingRepository.save(lending);
    }

    public void deleteLending(Integer item_number_publication, Integer num_ticket, Integer num_employee) {
        LendingId id = new LendingId(item_number_publication, num_ticket, num_employee);
        Lending lending = lendingRepository.findById(id).get();
        lendingRepository.delete(lending);
    }

    public ResponseEntity<String> editLending(@RequestBody LendingDTO lendingDTO) {
        try {
            LendingId id = new LendingId(lendingDTO.getItem_number_publication(), lendingDTO.getNum_ticket(), lendingDTO.getNum_employee());
            if(!lendingRepository.existsById(id)) {
                return ResponseEntity.badRequest().body("Записи выдачи не существует");
            }

            Lending lending = new Lending(lendingDTO.getItem_number_publication(), lendingDTO.getNum_ticket(),
                                        lendingDTO.getIssue_date(), lendingDTO.getReturn_period(),
                                        lendingDTO.getReturn_date(), lendingDTO.getNum_employee());
            lendingRepository.save(lending);

            return ResponseEntity.ok("Успех");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}


