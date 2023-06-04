package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.Pensioners;

@Repository
public interface PensionersRepository extends JpaRepository<Pensioners, Integer> { }