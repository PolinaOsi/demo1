package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.Shelving;

@Repository
public interface ShelvingRepository extends JpaRepository<Shelving, Integer> { }
