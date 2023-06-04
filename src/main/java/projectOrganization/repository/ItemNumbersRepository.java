package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.ItemNumbers;

@Repository
public interface ItemNumbersRepository extends JpaRepository<ItemNumbers, Integer> { }
