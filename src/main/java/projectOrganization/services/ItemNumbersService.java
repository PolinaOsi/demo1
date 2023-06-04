package projectOrganization.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.ItemNumbersDTO;
import projectOrganization.entity.ItemNumbers;
import projectOrganization.repository.ItemNumbersRepository;

import java.util.List;

@Service

public class ItemNumbersService {
    @Autowired
    ItemNumbersRepository itemNumbersRepository;

    public List<ItemNumbers> getAllItemNumbers() throws Exception {
        return (List<ItemNumbers>) itemNumbersRepository.findAll();
    }

    public ItemNumbers getItemNumbers(Integer number) {
        return itemNumbersRepository.findById(number).get();
    }

    public void addItemNumbers(ItemNumbersDTO request) {
        ItemNumbers itemNumbers = new ItemNumbers();
        itemNumbers.setNumber(request.getNumber());
        itemNumbers.setId_publication(request.getId_publication());
        itemNumbers.setDate_import(request.getDate_import());
        itemNumbers.setDate_writeoff(request.getDate_writeoff());
        itemNumbers.setNum_library(request.getNum_library());
        itemNumbersRepository.save(itemNumbers);
    }

    public void deleteItemNumbers(Integer number) {
        ItemNumbers itemNumbers = itemNumbersRepository.findById(number).get();
        itemNumbersRepository.delete(itemNumbers);
    }

    public ResponseEntity<String> editItemNumbers(@RequestBody ItemNumbersDTO itemNumbersDTO) {
        try {
            if(!itemNumbersRepository.existsById(itemNumbersDTO.getNumber())) {
                return ResponseEntity.badRequest().body("Номенклатурного номера не существует");
            }

            ItemNumbers itemNumbers = new ItemNumbers(itemNumbersDTO.getNumber(), itemNumbersDTO.getId_publication(),
                    itemNumbersDTO.getDate_import(), itemNumbersDTO.getDate_writeoff(),
                    itemNumbersDTO.getNum_library());
            itemNumbersRepository.save(itemNumbers);

            return ResponseEntity.ok("Успех");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}


