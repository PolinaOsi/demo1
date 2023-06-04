package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.PublicationTypes;

@Repository
public interface PublicationTypesRepository extends JpaRepository<PublicationTypes, Integer> { }