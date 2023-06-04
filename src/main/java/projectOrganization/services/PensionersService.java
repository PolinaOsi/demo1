package projectOrganization.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.PensionersDTO;
import projectOrganization.entity.Pensioners;
import projectOrganization.repository.PensionersRepository;

import java.util.List;

@Service
public class PensionersService {
        @Autowired
        PensionersRepository pensionersRepository;

        public List<Pensioners> getAllPensioners() throws Exception {
            return (List<Pensioners>) pensionersRepository.findAll();
        }

        public Pensioners getPensioners(Integer id_pensioner) { return pensionersRepository.findById(id_pensioner).get(); }

        public void addPensioners(PensionersDTO request) {
            Pensioners pensioners = new Pensioners();
            pensioners.setId_pensioner(request.getId_pensioner());
            pensioners.setPension(request.getPension());

            pensionersRepository.save(pensioners);
        }

        public void deletePensioners(Integer id_pensioner) {
            Pensioners pensioners = pensionersRepository.findById(id_pensioner).get();
            pensionersRepository.delete(pensioners);
        }

        public ResponseEntity<String> editPensioners(@RequestBody PensionersDTO pensionersDTO) {
            try {
                if(!pensionersRepository.existsById(pensionersDTO.getId_pensioner())) {
                    return ResponseEntity.badRequest().body("Пенсионера не существует");
                }

                Pensioners pensioners = new Pensioners(pensionersDTO.getId_pensioner(), pensionersDTO.getPension());
                pensionersRepository.save(pensioners);

                return ResponseEntity.ok("Успех");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Ошибка");
            }
        }
    }



