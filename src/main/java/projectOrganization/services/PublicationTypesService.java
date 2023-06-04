package projectOrganization.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.PublicationTypesDTO;
import projectOrganization.entity.PublicationTypes;
import projectOrganization.repository.PublicationTypesRepository;

import java.util.List;

@Service
public class PublicationTypesService {
        @Autowired
        PublicationTypesRepository publicationTypesRepository;

        public List<PublicationTypes> getAllPublicationTypes() throws Exception {
            return (List<PublicationTypes>) publicationTypesRepository.findAll();
        }

        public PublicationTypes getPublicationTypes(Integer id_type) { return publicationTypesRepository.findById(id_type).get(); }

        public void addPublicationTypes(PublicationTypesDTO request) {
            PublicationTypes publicationTypes = new PublicationTypes();
            publicationTypes.setId_type(request.getId_type());
            publicationTypes.setName_type(request.getName_type());

            publicationTypesRepository.save(publicationTypes);
        }

        public void deletePublicationTypes(Integer id_type) {
            PublicationTypes publicationTypes = publicationTypesRepository.findById(id_type).get();
            publicationTypesRepository.delete(publicationTypes);
        }

        public ResponseEntity<String> editPublicationTypes(@RequestBody PublicationTypesDTO publicationTypesDTO) {
            try {
                if(!publicationTypesRepository.existsById(publicationTypesDTO.getId_type())) {
                    return ResponseEntity.badRequest().body("Типа изданий не существует");
                }

                PublicationTypes publicationTypes = new PublicationTypes(publicationTypesDTO.getId_type(), publicationTypesDTO.getName_type());
                publicationTypesRepository.save(publicationTypes);

                return ResponseEntity.ok("Успех");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Ошибка");
            }
        }
    }





