package ELearning.Portal.Repository;

import ELearning.Portal.Model.Course;
import ELearning.Portal.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseName(String Name);
    List<Course> findAllByProfessor(Professor professor);
}
