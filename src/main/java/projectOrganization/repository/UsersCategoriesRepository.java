package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.UserCategories;

@Repository
public interface UsersCategoriesRepository extends JpaRepository<UserCategories, Integer> { }