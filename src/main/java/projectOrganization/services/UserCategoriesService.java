package projectOrganization.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.UserCategoriesDTO;
import projectOrganization.entity.UserCategories;
import projectOrganization.repository.UsersCategoriesRepository;

import java.util.List;

@Service
public class UserCategoriesService {
        @Autowired
        UsersCategoriesRepository usersCategoriesRepository;

        public List<UserCategories> getAllUserCategories() throws Exception {
            return (List<UserCategories>) usersCategoriesRepository.findAll();
        }

        public UserCategories getUserCategories(Integer id_category) { return usersCategoriesRepository.findById(id_category).get(); }

        public void addUserCategories(UserCategoriesDTO request) {
            UserCategories userCategories = new UserCategories();
            userCategories.setId_category(request.getId_category());
            userCategories.setName_category(request.getName_category());

            usersCategoriesRepository.save(userCategories);
        }

        public void deleteUserCategories(Integer id_category) {
            UserCategories userCategories = usersCategoriesRepository.findById(id_category).get();
            usersCategoriesRepository.delete(userCategories);
        }

        public ResponseEntity<String> editUserCategories(@RequestBody UserCategoriesDTO userCategoriesDTO) {
            try {
                if(!usersCategoriesRepository.existsById(userCategoriesDTO.getId_category())) {
                    return ResponseEntity.badRequest().body("Категории пользователей не существует");
                }

                UserCategories userCategories = new UserCategories(userCategoriesDTO.getId_category(), userCategoriesDTO.getName_category());
                usersCategoriesRepository.save(userCategories);

                return ResponseEntity.ok("Успех");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Ошибка");
            }
        }
    }





