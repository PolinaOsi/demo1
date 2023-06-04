package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.Workers;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Integer> { }