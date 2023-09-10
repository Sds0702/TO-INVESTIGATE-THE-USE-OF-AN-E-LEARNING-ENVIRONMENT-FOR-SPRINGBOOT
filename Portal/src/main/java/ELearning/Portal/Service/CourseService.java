package ELearning.Portal.Service;

import ELearning.Portal.Model.Course;
import ELearning.Portal.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CourseService {

    public default List<Course> getAll() {
        return null;
    }

    List<Course> getAllCourses();

    Course saveCourse(Course course);

    Course getCourseById(Long id);

    Course updateCourse(Course course);

    void deleteCourseById(Long id);
}
