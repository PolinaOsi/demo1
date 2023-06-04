package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.Restrictions;

@Repository
public interface RestrictionsRepository extends JpaRepository<Restrictions, Integer> { }