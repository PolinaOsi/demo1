package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.LocationPublications;
import projectOrganization.keys.LocationPublicationsId;

@Repository
public interface LocationPublicationRepository extends JpaRepository<LocationPublications, LocationPublicationsId> { }