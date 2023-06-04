package projectOrganization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projectOrganization.entity.Scientists;
import projectOrganization.entity.Students;
import projectOrganization.entity.Users;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
//    public List<Students> findByName_university(String name_university);
//    public List<Students> findByFaculty(String faculty);
//    public List<Scientists> findByScientific_topic(String scientific_topic);

//    @Query(value = "SELECT Фамилия, Имя, Отчество \n" +
//            "FROM Студенты INNER JOIN Пользователи \n" +
//            "    ON Студенты.ID_студента = Пользователи.ID_Пользователя \n" +
//            "WHERE Студенты.Учебное_заведение = :name_university\n" +
//            "        AND Студенты.Факультет = :faculty \n", nativeQuery = true)
//     List<Students> getAllStudentsByNameUniversityFaculty(@Param("name_university") String Учебное_заведение, @Param("faculty") String Факультет);
}
