package projectOrganization.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projectOrganization.dto.LocationPublicationDTO;
import projectOrganization.entity.LocationPublications;
import projectOrganization.keys.LocationPublicationsId;
import projectOrganization.repository.LocationPublicationRepository;

import java.util.List;

@Service
public class LocationPublicationsService {
    @Autowired
    LocationPublicationRepository locationPublicationRepository;

    public List<LocationPublications> getAllLocationPublications() throws Exception {
        return (List<LocationPublications>) locationPublicationRepository.findAll();
    }

    public LocationPublications getLocationPublications(Integer id_publication, Integer id_shelving, Integer num_shelf) {
        LocationPublicationsId id = new LocationPublicationsId(num_shelf, num_shelf, num_shelf);
        return locationPublicationRepository.findById(id).get();
    }

    public void addLocationPublications(LocationPublicationDTO request) {
        LocationPublications locationPublications = new LocationPublications();
        locationPublications.setId_publication(request.getId_publication());
        locationPublications.setId_shelving(request.getId_shelving());
        locationPublications.setNum_shelf(request.getNum_shelf());
        locationPublicationRepository.save(locationPublications);
    }

    public void deleteLocationPublications(Integer id_publication, Integer id_shelving, Integer num_shelf) {
        LocationPublicationsId id = new LocationPublicationsId(num_shelf, num_shelf, num_shelf);
        LocationPublications locationPublications = locationPublicationRepository.findById(id).get();
        locationPublicationRepository.delete(locationPublications);
    }

    public ResponseEntity<String> editLocationPublications(@RequestBody LocationPublicationDTO locationPublicationDTO) {
        try {
            LocationPublicationsId id = new LocationPublicationsId(locationPublicationDTO.getId_publication(),
                                                                    locationPublicationDTO.getId_shelving(),
                                                                    locationPublicationDTO.getNum_shelf());
            if(!locationPublicationRepository.existsById(id)) {
                return ResponseEntity.badRequest().body("Раположения изданий не существует");
            }

            LocationPublications locationPublication = new LocationPublications(locationPublicationDTO.getId_publication(),
                                                            locationPublicationDTO.getId_shelving(),
                                                            locationPublicationDTO.getNum_shelf());
            locationPublicationRepository.save(locationPublication);

            return ResponseEntity.ok("Успех");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}


