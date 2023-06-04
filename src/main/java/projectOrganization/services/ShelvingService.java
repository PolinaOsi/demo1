package projectOrganization.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.ShelvingDTO;
import projectOrganization.entity.Shelving;
import projectOrganization.repository.ShelvingRepository;

import java.util.List;

@Service
public class ShelvingService {
    @Autowired
    private ShelvingRepository shelvingRepository;

    public List<Shelving> getAllShelving() throws Exception {
        return (List<Shelving>) shelvingRepository.findAll();
    }

    public Shelving getShelving(Integer id_shelving) { return shelvingRepository.findById(id_shelving).get(); }

    public void addShelving(ShelvingDTO request) {
        Shelving shelving = new Shelving();
        shelving.setId_shelving(request.getId_shelving());
        shelving.setNum_library(request.getNum_library());
        shelving.setNum_hall(request.getNum_hall());
        shelving.setNum_shelving(request.getNum_shelving());

        shelvingRepository.save(shelving);
    }

    public void deleteShelving(Integer id_shelving) {
        Shelving shelving = shelvingRepository.findById(id_shelving).get();
        shelvingRepository.delete(shelving);
    }

    public ResponseEntity<String> editShelving(@RequestBody ShelvingDTO shelvingDTO) {
        try {
            if(!shelvingRepository.existsById(shelvingDTO.getId_shelving())) {
                return ResponseEntity.badRequest().body("Стеллажа не существует");
            }

            Shelving shelving = new Shelving(shelvingDTO.getId_shelving(), shelvingDTO.getNum_library(), shelvingDTO.getNum_hall(), shelvingDTO.getNum_shelving());
            shelvingRepository.save(shelving);

            return ResponseEntity.ok("Успех");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}





