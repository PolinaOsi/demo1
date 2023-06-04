package projectOrganization.services;
import projectOrganization.dto.AuthorsDTO;
import projectOrganization.entity.Authors;
import projectOrganization.repository.AuthorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorsService {
    private final AuthorsRepository authorsRepository;

    public List<Authors> getAllAuthors() {
        return authorsRepository.findAll();
    }

    public Authors getAuthors(Integer id_author) {
        return authorsRepository.findById(id_author).get();
    }

    public void addAuthors(AuthorsDTO request) {
        Authors authors = new Authors();

        authors.setId_author(request.getId_author());
        authors.setSurname(request.getSurname());
        authors.setName(request.getName());
        authors.setPatronymic(request.getPatronymic());
        authors.setDate_birth(request.getDate_birth());
        authorsRepository.save(authors);
    }

    public void deleteAuthors(Integer id_author) {
        Authors authors = authorsRepository.findById(id_author).get();
        authorsRepository.delete(authors);
    }

    public ResponseEntity<String> editAuthors(@RequestBody AuthorsDTO authorsDTO) {
        try {
            if(!authorsRepository.existsById(authorsDTO.getId_author())) {
                return ResponseEntity.badRequest().body("Автора не существует");
            }

            Authors authors = new Authors(authorsDTO.getId_author(), authorsDTO.getSurname(), authorsDTO.getName(), authorsDTO.getPatronymic(), authorsDTO.getDate_birth());
            authorsRepository.save(authors);

            return ResponseEntity.ok("Успех");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

}

