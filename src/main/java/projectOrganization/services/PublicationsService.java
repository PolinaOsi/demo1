package projectOrganization.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.PublicationsDTO;
import projectOrganization.entity.Publications;
import projectOrganization.repository.PublicationsRepository;

import java.util.List;

@Service
public class PublicationsService {
        @Autowired
        PublicationsRepository publicationsRepository;

        public List<Publications> getAllPublications() throws Exception {
            return (List<Publications>) publicationsRepository.findAll();
        }

        public Publications getPublications(Integer id_publication) { return publicationsRepository.findById(id_publication).get(); }

        public void addPublications(PublicationsDTO request) {
            Publications publications = new Publications();
            publications.setId_publication(request.getId_publication());
            publications.setName(request.getName());
            publications.setCategory(request.getCategory());
            publications.setType(request.getType());
            publications.setAuthor(request.getAuthor());
            publicationsRepository.save(publications);
        }

        public void deletePublications(Integer id_publication) {
            Publications publications = publicationsRepository.findById(id_publication).get();
            publicationsRepository.delete(publications);
        }

        public ResponseEntity<String> editPublications(@RequestBody PublicationsDTO publicationsDTO) {
            try {
                if(!publicationsRepository.existsById(publicationsDTO.getId_publication())) {
                    return ResponseEntity.badRequest().body("Издания не существует");
                }

                Publications publications = new Publications(publicationsDTO.getId_publication(), publicationsDTO.getName(),
                        publicationsDTO.getCategory(),
                        publicationsDTO.getType(),
                        publicationsDTO.getAuthor());
                publicationsRepository.save(publications);

                return ResponseEntity.ok("Успех");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Ошибка");
            }
        }
    }



