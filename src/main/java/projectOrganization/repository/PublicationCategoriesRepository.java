package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.PublicationCategories;

@Repository
public interface PublicationCategoriesRepository extends JpaRepository<PublicationCategories, Integer> { }