package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.Libraries;

@Repository
public interface LibrariesRepository extends JpaRepository<Libraries, Integer> { }