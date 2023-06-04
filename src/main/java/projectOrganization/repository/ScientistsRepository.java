package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.Scientists;

@Repository
public interface ScientistsRepository extends JpaRepository<Scientists, Integer> { }