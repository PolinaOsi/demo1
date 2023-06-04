package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.Publications;

@Repository
public interface PublicationsRepository extends JpaRepository<Publications, Integer> { }
