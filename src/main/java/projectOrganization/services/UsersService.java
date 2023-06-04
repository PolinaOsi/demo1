package projectOrganization.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.UsersDTO;
import projectOrganization.entity.Users;
import projectOrganization.repository.UsersRepository;

import java.util.List;

@Service
public class UsersService {
        @Autowired
        UsersRepository usersRepository;

        public List<Users> getAllUsers() throws Exception {
            return (List<Users>) usersRepository.findAll();
        }

        public Users getUsers(Integer id_user) {
            return usersRepository.findById(id_user).get();
        }

        public void addUsers(UsersDTO request) {
            Users users = new Users();
            users.setId_user(request.getId_user());
            users.setCategory(request.getCategory());
            users.setSurname(request.getSurname());
            users.setName(request.getName());
            users.setPatronymic(request.getPatronymic());

            usersRepository.save(users);
        }

        public void deleteUsers(Integer id_user) {
            Users users = usersRepository.findById(id_user).get();
            usersRepository.delete(users);
        }

        public ResponseEntity<String> editUsers(@RequestBody UsersDTO usersDTO) {
            try {
                if(!usersRepository.existsById(usersDTO.getId_user())) {
                    return ResponseEntity.badRequest().body("Пользователя не существует");
                }

                Users users = new Users(usersDTO.getId_user(), usersDTO.getCategory(), usersDTO.getSurname(),
                        usersDTO.getName(), usersDTO.getPatronymic());
                usersRepository.save(users);

                return ResponseEntity.ok("Успех");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Ошибка");
            }
        }
    }



