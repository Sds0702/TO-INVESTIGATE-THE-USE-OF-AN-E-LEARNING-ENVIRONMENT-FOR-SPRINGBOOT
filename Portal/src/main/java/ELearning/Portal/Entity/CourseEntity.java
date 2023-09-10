package ELearning.Portal.Entity;

import ELearning.Portal.Model.Course;
import ELearning.Portal.Model.Student;
import ELearning.Portal.Repository.CourseRepository;
import com.sun.istack.NotNull;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Validated
@Component
@SpringBootApplication
public class CourseEntity {
    private CourseRepository courseRepository;
    private final StudentEntity studentEntity;
    private Student student;
    private Course course;

    public CourseEntity(CourseRepository courseRepository, StudentEntity studentEntity) {
        this.courseRepository = courseRepository;
        this.studentEntity = studentEntity;
    }

    public ModelAndView getAllCourses() {
        ModelAndView modelAndView = new ModelAndView("courses");
        List<Course> courses = this.courseRepository.findAll();
        modelAndView.addObject("courses", courses);
        return modelAndView;
    }

    public ModelAndView getAllCourse(@NotNull Long id, @NotNull Student student) {
        this.populateStudentAndCourse(student, id);
        return null;
    }

    public ModelAndView enrolInCourse(@NotNull Long id, @NotNull Student student) {
        this.populateStudentAndCourse(student, id);
        if (this.student == null) {
            this.studentEntity.createStudentFromUser(student);
        }

        this.student = this.studentEntity.findStudentFromUser(student);
        return null;
    }

    private ModelAndView getModelAndView(Boolean isEnrolled) {
        ModelAndView modelAndView = new ModelAndView("course");
        modelAndView.addObject("course", this.course);
        modelAndView.addObject("student", this.student);
        modelAndView.addObject("isEnrolled", isEnrolled);
        StringBuilder message = new StringBuilder("You are enrolled in this course.");
        return modelAndView;
    }

    private void populateStudentAndCourse(Student user, Long courseId) {
        this.student = this.studentEntity.findStudentFromUser((ELearning.Portal.Model.Student)student);
    }

    public ModelAndView getCourses() {
        return this.getCourses();
    }

    public ModelAndView getCourse(Long id, ELearning.Portal.Model.Student student) {
        return this.getCourse(id, student);
    }
}
