package projectOrganization.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectOrganization.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    @Query(value = "SELECT * \n" +
            "FROM Сотрудники \n" +
            "WHERE \"№_библиотеки\" = :num_lib AND \"№_зала\" = :num_hall", nativeQuery = true)
    List<Employees> query(@Param("num_lib")Integer num_lib, @Param("num_hall")Integer num_hall);
}

