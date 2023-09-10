package ELearning.Portal.Entity;

import ELearning.Portal.Model.Student;
import ELearning.Portal.Repository.StudentRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
@SpringBootApplication
public class StudentEntity {
    private final StudentRepository studentRepository;

    public StudentEntity(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /*public EntityModel<Student> getStudentByIdJson(Integer id) {
        Student student = (Student)this.studentRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Course with id" + id + "not found.");
        });
        return EntityModel.of(student, new Link[]{WebMvcLinkBuilder.linkTo(((StudentController)WebMvcLinkBuilder.methodOn(StudentController.class, new Object[0])).getStudentJson(student.getId())).withSelfRel()});
    }*/

    public ModelAndView getStudentById(Integer id) {
        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject(this.studentRepository.findById(id).orElseThrow(RuntimeException::new));
        return modelAndView;
    }

    public ResponseEntity<?> updateOrCreateAccount(Student newStudent, Long id) {
        return null;
    }

    public ModelAndView getProfileToEdit(Long id) {
        return null;
    }

    public ModelAndView getProfile(Student student, String profile) {
        return null;
    }

    public ModelAndView editProfile(Student student) {
        return null;
    }

    public void createStudentFromUser(Student user) {
    }

    public Student findStudentFromUser(Student student) {
        return student;
    }
}
