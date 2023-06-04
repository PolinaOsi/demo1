package projectOrganization.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.LibrariesDTO;
import projectOrganization.entity.Libraries;
import projectOrganization.repository.LibrariesRepository;

import java.util.List;

@Service
public class LibrariesService {
        @Autowired
        LibrariesRepository librariesRepository;

        public List<Libraries> getAllLibraries() throws Exception {
            return (List<Libraries>) librariesRepository.findAll();
        }

        public Libraries getLibraries(Integer id_library) { return librariesRepository.findById(id_library).get(); }

        public void addLibraries(LibrariesDTO request) {
            Libraries libraries = new Libraries();
            libraries.setId_library(request.getId_library());
            libraries.setName_library(request.getName_library());
            libraries.setAddress_library(request.getAddress_library());
            librariesRepository.save(libraries);
        }

        public void deleteLibraries(Integer id_library) {
            Libraries libraries = librariesRepository.findById(id_library).get();
            librariesRepository.delete(libraries);
        }

        public ResponseEntity<String> editLibraries(@RequestBody LibrariesDTO librariesDTO) {
            try {
                if(!librariesRepository.existsById(librariesDTO.getId_library())) {
                    return ResponseEntity.badRequest().body("Библиотеки не существует");
                }

                Libraries libraries = new Libraries(librariesDTO.getId_library(), librariesDTO.getName_library(),
                        librariesDTO.getAddress_library());
                librariesRepository.save(libraries);

                return ResponseEntity.ok("Успех");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Ошибка");
            }
        }
    }



