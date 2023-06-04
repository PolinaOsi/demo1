package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.Students;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
    @Query(value = "SELECT * \n" +
            "FROM Студенты INNER JOIN Пользователи \n" +
            "    ON Студенты.ID_студента = Пользователи.ID_Пользователя \n" +
            "WHERE Студенты.Учебное_заведение = :name_university\n" +
            "        AND Студенты.Факультет = :faculty \n", nativeQuery = true)
    List<Students> getAllStudentsByNameUniversityFaculty(@Param("name_university") String name_university, @Param("faculty") String faculty);
}
