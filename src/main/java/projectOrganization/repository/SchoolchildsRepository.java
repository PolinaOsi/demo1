package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.Schoolhilds;

@Repository
public interface SchoolchildsRepository extends JpaRepository<Schoolhilds, Integer> { }