package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.Lending;
import projectOrganization.keys.LendingId;

@Repository
public interface LendingRepository extends JpaRepository<Lending, LendingId> {


}