package projectOrganization.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.PublicationCategoriesDTO;
import projectOrganization.entity.PublicationCategories;
import projectOrganization.repository.PublicationCategoriesRepository;

import java.util.List;

@Service
public class PublicationCategoriesService {
        @Autowired
        PublicationCategoriesRepository publicationCategoriesRepository;

        public List<PublicationCategories> getAllPublicationCategories() throws Exception {
            return (List<PublicationCategories>) publicationCategoriesRepository.findAll();
        }

        public PublicationCategories getPublicationCategories(Integer id_category) { return publicationCategoriesRepository.findById(id_category).get(); }

        public void addPublicationCategories(PublicationCategoriesDTO request) {
            PublicationCategories publicationCategories = new PublicationCategories();
            publicationCategories.setId_category(request.getId_category());
            publicationCategories.setName_category(request.getName_category());

            publicationCategoriesRepository.save(publicationCategories);
        }

        public void deletePublicationCategories(Integer id_category) {
            PublicationCategories publicationCategories = publicationCategoriesRepository.findById(id_category).get();
            publicationCategoriesRepository.delete(publicationCategories);
        }

        public ResponseEntity<String> editPublicationCategories(@RequestBody PublicationCategoriesDTO publicationCategoriesDTO) {
            try {
                if(!publicationCategoriesRepository.existsById(publicationCategoriesDTO.getId_category())) {
                    return ResponseEntity.badRequest().body("Категории изданий не существует");
                }

                PublicationCategories publicationCategories = new PublicationCategories(publicationCategoriesDTO.getId_category(), publicationCategoriesDTO.getName_category());
                publicationCategoriesRepository.save(publicationCategories);

                return ResponseEntity.ok("Успех");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Ошибка");
            }
        }
    }




