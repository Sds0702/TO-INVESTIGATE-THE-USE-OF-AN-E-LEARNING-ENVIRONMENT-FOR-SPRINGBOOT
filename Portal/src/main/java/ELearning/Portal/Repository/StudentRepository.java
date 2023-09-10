package ELearning.Portal.Repository;

import ELearning.Portal.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByUserId(Long userId);

    Student findByUserName(String currentUsername);

    Student getUserName(Long UserId);

    Student getEnrolledCourses(String EnrolledCourses);

   Student findById(Long userID);
}
