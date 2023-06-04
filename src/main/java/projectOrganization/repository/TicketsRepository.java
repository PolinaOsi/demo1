package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.Tickets;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Integer> { }
